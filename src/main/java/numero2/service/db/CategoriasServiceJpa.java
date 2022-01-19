package numero2.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import numero2.model.Categoria;
import numero2.repository.CategoriasRepository;
import numero2.service.ICategoriasService;

@Service
@Primary
public class CategoriasServiceJpa implements ICategoriasService {
	
	@Autowired
	private CategoriasRepository categoriasRepo;
	

	
	public void guardar(Categoria categoria) {
		categoriasRepo.save(categoria);

	}

	
	public List<Categoria> buscarTodas() {
		return categoriasRepo.findAll();
	}


	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = categoriasRepo.findById(idCategoria);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}


	public void eliminar(Integer idCategoria) {
		categoriasRepo.deleteById(idCategoria);
	}


	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
	return categoriasRepo.findAll(page);
	}

}
