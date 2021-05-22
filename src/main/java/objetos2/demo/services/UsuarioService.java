package objetos2.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import objetos2.demo.converters.UsuarioConverter;
import objetos2.demo.entities.Usuario;
import objetos2.demo.exception.UsuarioExistenteException;
import objetos2.demo.models.UsuarioModel;
import objetos2.demo.repositories.IUsuarioRepository;
import objetos2.demo.services.implementation.IUsuarioService;


@Service("usuarioService")
public class UsuarioService implements IUsuarioService {

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