package numero2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import numero2.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
}
