/**
 * Created by ikachko on 7/11/18.
 */
public class WrongNumberOfSimulationException extends Exception {
	public	WrongNumberOfSimulationException() {
		super();
	}

	public	WrongNumberOfSimulationException(String message) {
		super(message);
	}

	public	WrongNumberOfSimulationException(String message, Throwable cause) {
		super(message,cause);
	}

	public	WrongNumberOfSimulationException(Throwable cause) {
		super(cause);
	}
}
