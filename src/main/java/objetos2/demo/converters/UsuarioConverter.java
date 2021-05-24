package objetos2.demo.converters;

import org.springframework.stereotype.Component;

import objetos2.demo.entities.Usuario;
import objetos2.demo.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getIdUsuario(),usuario.getNombreUsuario(),usuario.getNombre(),usuario.getApellido(),usuario.getTipoDocumento(),usuario.getNroDocumento(),usuario.getEmail(),usuario.getPassword(),usuario.getTipoUsuario(),usuario.isActivo(),usuario.getPerfil());
	}

	public Usuario modelToEntity(UsuarioModel usuario) {
		return new Usuario(usuario.getIdUsuario(),usuario.getNombreUsuario(),usuario.getNombre(),usuario.getApellido(),usuario.getTipoDocumento(),usuario.getNroDocumento(),usuario.getEmail(),usuario.getPassword(),usuario.getTipoUsuario(),usuario.isActivo(),usuario.getPerfil());
	}
}
