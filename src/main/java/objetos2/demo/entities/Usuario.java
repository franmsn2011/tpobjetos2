package objetos2.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nombre", unique=true, nullable=false, length=45)
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="tipoDoc")
	private int tipoDoc;
	
	@Column(name="nroDocumento")
	private int nroDocumento;
	
	@Column(name="password")
	private String password;
	
	@Column(name="tipoUsuario")
	private int tipoUsuario;
	
	@Column(name="activo")
	private boolean activo;
	

	public Usuario() {}


	public Usuario(int idUsuario, String nombre, String apellido, int edad, int tipoDoc, int nroDocumento, String password,
			boolean activo,int tipoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.tipoDoc = tipoDoc;
		this.nroDocumento = nroDocumento;
		this.password = password;
		this.activo = activo;
		this.tipoUsuario = tipoUsuario;
	}

	
	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getTipoDoc() {
		return tipoDoc;
	}


	public void setTipoDoc(int tipoDoc) {
		this.tipoDoc = tipoDoc;
	}


	public int getNroDocumento() {
		return nroDocumento;
	}


	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}