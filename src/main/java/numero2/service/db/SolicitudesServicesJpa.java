package numero2.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import numero2.model.Solicitud;
import numero2.repository.SolicitudesRepository;
import numero2.service.ISolicitudesService;

@Service
@Primary
public class SolicitudesServicesJpa implements ISolicitudesService {
	@Autowired
	private SolicitudesRepository repoSoli;

	@Override
	public List<Solicitud> buscarTodas() {
		return repoSoli.findAll();
	}

	@Override
	public void guardar(Solicitud solicitud) {
		repoSoli.save(solicitud);

	}

	@Override
	public void Eliminar(Integer id) {
		repoSoli.deleteById(id);

	}

	@Override
	public Page<Solicitud> buscarTodas(Pageable page) {
		return repoSoli.findAll(page);
	}

	@Override
	public Solicitud buscarPorId(Integer id) {
		Optional<Solicitud> optional = repoSoli.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
