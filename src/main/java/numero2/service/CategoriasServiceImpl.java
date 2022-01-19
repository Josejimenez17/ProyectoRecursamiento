package numero2.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import numero2.model.Categoria;

@Service
public class CategoriasServiceImpl implements ICategoriasService {
 private List <Categoria> lista=null;
 
 public CategoriasServiceImpl() {
	 
	 lista = new LinkedList<Categoria>();
	 
	 Categoria categoria1 = new Categoria();
	 categoria1.setId(1);
	 categoria1.setNombre("Contabilidad");
	 categoria1.setDescripcion("Trabajos relacionados con la contabilidad");
	 
	 Categoria categoria2 = new Categoria();
	 categoria2.setId(2);
	 categoria2.setNombre("Ventas");
	 categoria2.setDescripcion("Trabajos relacionados con las ventas");
	 
	 Categoria categoria3 = new Categoria();
	 categoria3.setId(3);
	 categoria3.setNombre("Comunicaciones");
	 categoria3.setDescripcion("Trabajos relacionados con comunicaciones");
	 
	 Categoria categoria4 = new Categoria();
	 categoria4.setId(4);
	 categoria4.setNombre("Arquitectura");
	 categoria4.setDescripcion("Trabajos de arquitectura");
	 
	 Categoria categoria5 = new Categoria();
	 categoria5.setId(5);
	 categoria5.setNombre("Educación");
	 categoria5.setDescripcion("Trabajos relacionados co la educación");
	 
	 Categoria categoria6 = new Categoria();
	 categoria6.setId(6);
	 categoria6.setNombre("Desarrllo de software");
	 categoria6.setDescripcion("Trabajos relacionados con el desarrllo de software");
	 
	 lista.add(categoria1);
	 lista.add(categoria2);
	 lista.add(categoria3);
	 lista.add(categoria4);
	 lista.add(categoria5);
	 lista.add(categoria6);
	 	 
 }

@Override
public void guardar(Categoria categoria) {
	lista.add(categoria);
	
}

@Override
public List<Categoria> buscarTodas() {
	
	return lista;
}

@Override
public Categoria buscarPorId(Integer idCategoria) {
	for(Categoria c: lista) {
		if(c.getId()==idCategoria) {
			return c;
		}
}
	return null;
}

@Override
public void eliminar(Integer idCategoria) {
	// TODO Auto-generated method stub
	
}

@Override
public Page<Categoria> buscarTodas(Pageable page) {
	// TODO Auto-generated method stub
	return null;
}
	
}
