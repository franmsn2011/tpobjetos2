package objetos2.demo.converters;

import org.springframework.stereotype.Component;

import objetos2.demo.entities.Usuario;
import objetos2.demo.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getIdUsuario(),usuario.getNombre(),usuario.getApellido(),usuario.getEdad(),usuario.getTipoDoc(),usuario.getNroDocumento(),usuario.getPassword(),usuario.isActivo(),usuario.getTipoUsuario());
	}

	public Usuario modelToEntity(UsuarioModel usuario) {
		return new Usuario(usuario.getIdUsuario(),usuario.getNombre(),usuario.getApellido(),usuario.getEdad(),usuario.getTipoDoc(),usuario.getNroDocumento(),usuario.getPassword(),usuario.isActivo(),usuario.getTipoUsuario());
	}
}
