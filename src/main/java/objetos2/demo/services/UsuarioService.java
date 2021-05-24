package objetos2.demo.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import objetos2.demo.converters.UsuarioConverter;
import objetos2.demo.entities.Perfil;
import objetos2.demo.entities.UserRole;
import objetos2.demo.entities.Usuario;
import objetos2.demo.exception.UsuarioExistenteException;
import objetos2.demo.models.UsuarioModel;
import objetos2.demo.repositories.IUsuarioRepository;
import objetos2.demo.services.implementation.IUsuarioService;


@Service("usuarioService")
public class UsuarioService implements IUsuarioService ,UserDetailsService{

	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Override
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}
	@Override
	public UserDetails loadUserByNombreUsuario(String nombreUsuario) throws UsernameNotFoundException {
		objetos2.demo.entities.Usuario user = usuarioRepository.findByNombreUsuarioAndFetchPerfilEagerly(nombreUsuario);
		return buildUser(user, buildGrantedAuthorities(user.getPerfil()));
	}
	
	private User buildUser(objetos2.demo.entities.Usuario user, List<GrantedAuthority> grantedAuthorities) {
		return new User(user.getNombreUsuario(), user.getPassword(), user.isActivo(),
						true, true, true, //accountNonExpired, credentialsNonExpired, accountNonLocked,
						grantedAuthorities);
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Perfil perfil) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		
			grantedAuthorities.add(new SimpleGrantedAuthority(perfil.getPerfil()));
		
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}

	@Override
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel) {
		try {
			Usuario usuario= usuarioRepository.save(usuarioConverter.modelToEntity(usuarioModel));
			return usuarioConverter.entityToModel(usuario);
		} catch (Exception e) {
			throw new UsuarioExistenteException(
					"No se puede agregar ese usuario porque ya hay un usuario con ese nombre");

		}
//		return usuarioConverter.entityToModel(usuario);
	}

	@Override
	public boolean remove(int id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean darDeBaja(int idUsuario) {
		try {
			Usuario u= usuarioRepository.findByIdUsuario(idUsuario);
			u.setActivo(false);
			insertOrUpdate(usuarioConverter.entityToModel(u));
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public UsuarioModel findById(int id) {
		return usuarioConverter.entityToModel(usuarioRepository.findByIdUsuario(id));
	}

	@Override
	public UsuarioModel findByNombre(String name) {
		UsuarioModel u= null;
		if(usuarioRepository.findByNombre(name)!=null){
			u=usuarioConverter.entityToModel(usuarioRepository.findByNombre(name));
		}
		return u;
	}
	
	@Override
	public List<UsuarioModel> findByDegreeNombre(String degreeName) {
		List<UsuarioModel> models = new ArrayList<UsuarioModel>();
		
		return models;
	}
	@Override
	public boolean validoPassword(UsuarioModel usuario,String password) {
		return !usuario.getPassword().equalsIgnoreCase(password);
	}
}