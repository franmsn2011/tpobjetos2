package objetos2.demo.models;

public class Login {
	private String nombre;
	private String password;
	
	public Login() {
		super();
	}
	public Login(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
