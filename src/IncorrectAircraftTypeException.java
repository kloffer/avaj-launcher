import com.sun.corba.se.impl.presentation.rmi.ExceptionHandler;

/**
 * Created by ikachko on 7/11/18.
 */
public class IncorrectAircraftTypeException extends Exception {
	public	IncorrectAircraftTypeException() {
		super();
	}

	public	IncorrectAircraftTypeException(String message) {
		super(message);
	}

	public	IncorrectAircraftTypeException(String message, Throwable cause) {
		super(message,cause);
	}

	public	IncorrectAircraftTypeException(Throwable cause) {
		super(cause);
	}
}
