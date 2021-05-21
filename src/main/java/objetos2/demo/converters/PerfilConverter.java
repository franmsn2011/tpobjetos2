package objetos2.demo.converters;

import org.springframework.stereotype.Component;

import objetos2.demo.entities.Perfil;
import objetos2.demo.models.PerfilModel;
@Component("perfilConverter")
public class PerfilConverter {
	public PerfilModel entityToModel(Perfil perfil) {
		return new PerfilModel(perfil.getIdPerfil(),perfil.getNombre());
	}

	public Perfil modelToEntity(PerfilModel perfil) {
		return new Perfil(perfil.getIdPerfil(),perfil.getNombre());
	}
}
