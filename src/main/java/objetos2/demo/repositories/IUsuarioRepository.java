package objetos2.demo.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import objetos2.demo.entities.Usuario;
@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{

	public abstract Usuario findByIdUsuario(int id);
	
	public abstract Usuario findByNombre(String name);
	
}
