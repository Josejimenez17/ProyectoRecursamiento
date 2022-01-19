package numero2.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import numero2.model.Solicitud;



public interface ISolicitudesService {
	
	List<Solicitud> buscarTodas();

	void guardar(Solicitud solicitud);

	void Eliminar(Integer id);

	Page<Solicitud> buscarTodas(Pageable page);

	Solicitud buscarPorId(Integer id);
}
