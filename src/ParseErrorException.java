/**
 * Created by ikachko on 7/11/18.
 */
public class ParseErrorException extends Exception {
	public	ParseErrorException() {
		super();
	}

	public	ParseErrorException(String message) {
		super(message);
	}

	public	ParseErrorException(String message, Throwable cause) {
		super(message,cause);
	}

	public	ParseErrorException(Throwable cause) {
		super(cause);
	}
}
