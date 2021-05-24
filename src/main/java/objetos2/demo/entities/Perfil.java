package objetos2.demo.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="perfil")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;
	
	@Column(name="perfil")
	private String perfil;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="perfil")
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	

	public Perfil(int idPerfil, String perfil, Set<Usuario> usuarios) {
		super();
		this.idPerfil = idPerfil;
		this.perfil = perfil;
		this.usuarios = usuarios;
	}


	public Perfil() {}


	public int getIdPerfil() {
		return idPerfil;
	}


	public String getPerfil() {
		return perfil;
	}


	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Set<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}


	public Perfil(int idPerfil, String perfil, LocalDateTime createdAt, LocalDateTime updatedAt,
			Set<Usuario> usuarios) {
		super();
		this.idPerfil = idPerfil;
		this.perfil = perfil;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.usuarios = usuarios;
	}



	
}
