package objetos2.demo.models;



public class UsuarioModel {

	private int idUsuario;
	
	private String nombre;
	
	private String apellido;
	
	private int edad;
	
	private int tipoDoc;
	
	private int nroDocumento;
	
	private String password;
	
	private String tipoUsuario;
	
	private boolean activo;
	
	public UsuarioModel() {}

	public UsuarioModel(int idUsuario, String nombre, String apellido,int edad, int tipoDoc, int nroDocumento, String password,
			boolean activo,String tipoUsuario) {
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


	public String getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(String tipoUsuario) {
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
