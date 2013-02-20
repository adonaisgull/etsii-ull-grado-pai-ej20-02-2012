package p4ej5.alu4308.etsii.ull.es;

public class WrongParameterException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongParameterException (String msg) {
		super (msg);
	}
	
	public WrongParameterException (String msg, Throwable e) {
		super (msg, e);
	}
}