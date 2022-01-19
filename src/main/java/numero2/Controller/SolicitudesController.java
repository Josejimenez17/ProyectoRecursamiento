package numero2.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import numero2.model.Solicitud;
import numero2.model.Usuario;
import numero2.model.Vacante;
import numero2.service.ISolicitudesService;
import numero2.service.IUsuariosService;
import numero2.service.IVacantesService;
import numero2.util.Utileria;


@Controller
@RequestMapping(value = "/solicitudes")
public class SolicitudesController {
	
	@Value("${empleosapp.ruta.cv}")
	private String ruta;
	
	@Autowired
	private IVacantesService serviceVacantes;

	@Autowired
	private IUsuariosService serviceUsuarios;

	
	@Autowired
	private ISolicitudesService servicesSolicitudes;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Solicitud> lista = servicesSolicitudes.buscarTodas();
		model.addAttribute("solicitudes", lista);
		return "solicitudes/listSolicitudes";
	}
	
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Solicitud> lista = servicesSolicitudes.buscarTodas(page);
		model.addAttribute("solicitudes", lista);
		return "solicitudes/listSolicitudes";
	}
	
	@GetMapping("/create/{idVacante}")
	public String crear(Solicitud solicitud, @PathVariable Integer idVacante, Model model) {
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		return "solicitudes/formSolicitud";
	}
	
	@PostMapping("/save")
	public String guardar(Solicitud solicitud, BindingResult result, Model model, HttpSession session,
			@RequestParam("archivoCV") MultipartFile multiPart, RedirectAttributes attributes,
			Authentication authentication) {

		String username = authentication.getName();

		if (result.hasErrors()) {

			System.out.println("Existieron errores");
			return "solicitudes/formSolicitud";
		}

		if (!multiPart.isEmpty()) {
		
			String nombreArchivo = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreArchivo != null) { 
				solicitud.setArchivo(nombreArchivo);
			}
		}

		Usuario usuario = serviceUsuarios.buscarPorUsername(username);

		solicitud.setUsuario(usuario);
		solicitud.setFecha(new Date());
	
		servicesSolicitudes.guardar(solicitud);
		attributes.addFlashAttribute("msg", "Gracias por enviar tu CV!");

		// return "redirect:/solicitudes/index";
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idSolicitud, RedirectAttributes attributes) {
		servicesSolicitudes.Eliminar(idSolicitud);
		attributes.addFlashAttribute("msg", "La solicitud fue eliminada!.");
		// return "redirect:/solicitudes/index";
		return "redirect:/solicitudes/indexPaginate";
	}

	
	 // Data Binding para los tipo Date
	 
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	

}
