package objetos2.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import objetos2.demo.converters.PerfilConverter;
import objetos2.demo.entities.Perfil;
//import objetos2.demo.exception.PerfilExistenteException;
import objetos2.demo.models.PerfilModel;
import objetos2.demo.repositories.IPerfilRepository;
import objetos2.demo.services.implementation.IPerfilService;

@Service("perfilService")
public class PerfilService implements IPerfilService {

	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	
	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter;
	
	@Override
	public List<Perfil> getAll() {
		return perfilRepository.findAll();
	}

	@Override
	public PerfilModel insertOrUpdate(PerfilModel perfilModel) {
		//try {
			Perfil perfil= perfilRepository.save(perfilConverter.modelToEntity(perfilModel));
			return perfilConverter.entityToModel(perfil);
		/*} catch (Exception e) {
			throw new PerfilExistenteException(
					"No se puede agregar ese perfil porque ya hay un perfil con ese nombre");

		}*/
//		return perfilConverter.entityToModel(perfil);
	}

	@Override
	public boolean remove(int id) {
		try {
			perfilRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public PerfilModel findById(int id) {
		return perfilConverter.entityToModel(perfilRepository.findByIdPerfil(id));
	}

	@Override
	public PerfilModel findByNombre(String name) {
		PerfilModel u= null;
		if(perfilRepository.findByNombre(name)!=null){
			u=perfilConverter.entityToModel(perfilRepository.findByNombre(name));
		}
		return u;
	}
	
	@Override
	public List<PerfilModel> findByDegreeNombre(String degreeName) {
		List<PerfilModel> models = new ArrayList<PerfilModel>();
		
		return models;
	}
	
	
}
