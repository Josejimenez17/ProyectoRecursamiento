package net.itinagero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@GetMapping("/delete")
		public String eliminar(@RequestParam("id") int idVacante, Model model) {
		model.addAttribute("id", idVacante);
		System.out.print("Borrando vacante con id: " + idVacante);
			return "mensaje";
		}
	
 
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		System.out.println("idVacante: " + idVacante);
		model.addAttribute("idVacante", idVacante);
		return "vacantes/detalle";
	}
}
