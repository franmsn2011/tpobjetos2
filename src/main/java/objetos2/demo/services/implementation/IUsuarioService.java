package objetos2.demo.services.implementation;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import objetos2.demo.entities.Usuario;
import objetos2.demo.models.UsuarioModel;

public interface  IUsuarioService {
	public List<Usuario> getAll();
	
	public UsuarioModel findById(int id);
	
	public UsuarioModel findByNombreUsuario(String nombre);
	
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel);
	
	public boolean remove(int id);
	public List<Usuario> getAllPerfiles();
	public List<UsuarioModel> findByDegreeNombre(String degreeName);
	public boolean validoPassword(UsuarioModel usuario,String password); 
	public boolean darDeBaja(int idUsuario);
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException;
}
