package objetos2.demo.services.implementation;

import java.util.List;

import objetos2.demo.entities.Usuario;
import objetos2.demo.models.UsuarioModel;

public interface  IUsuarioService {
	public List<Usuario> getAll();
	
	public UsuarioModel findById(int id);
	
	public UsuarioModel findByNombre(String nombre);
	
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel);
	
	public boolean remove(int id);
	
	public List<UsuarioModel> findByDegreeNombre(String degreeName);
	public boolean validoPassword(UsuarioModel usuario,String password); 
	public boolean darDeBaja(int idUsuario);
}
