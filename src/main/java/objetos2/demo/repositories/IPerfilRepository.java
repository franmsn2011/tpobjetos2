package objetos2.demo.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import objetos2.demo.entities.Perfil;
@Repository("perfilRepository")
public interface IPerfilRepository extends JpaRepository<Perfil, Serializable>{
	public abstract Perfil findByIdPerfil(int id);
	public abstract Perfil findByNombre(String name);
}
