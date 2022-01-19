package numero2.service;

import java.util.List;
import numero2.model.Usuario;

public interface IUsuariosService {

	void guardar (Usuario usuario);
	void eliminar (Integer idUsuario);
	List<Usuario> buscarTodos();
	Usuario buscarPorUsername(String username);
	
	
}
