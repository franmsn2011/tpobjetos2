package objetos2.demo.services.implementation;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import objetos2.demo.entities.Perfil;
import objetos2.demo.entities.Usuario;
import objetos2.demo.models.PerfilModel;

public interface IPerfilService  {
	public List<Perfil> getAll();
	
	public PerfilModel findById(int id);
	
	public PerfilModel findByNombre(String nombre);
	
	public PerfilModel insertOrUpdate(PerfilModel usuarioModel);
	
	public boolean remove(int id);
	
	public List<PerfilModel> findByDegreeNombre(String degreeName);
}
