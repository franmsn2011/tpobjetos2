package objetos2.demo.exception;

public class UsuarioExistenteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioExistenteException(String s) {
		super(s);
	}
	
}
