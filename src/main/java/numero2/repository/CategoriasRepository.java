package numero2.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import numero2.model.Categoria;

//public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {
	public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
  