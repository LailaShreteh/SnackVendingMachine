package vm.exceptions;

public class InsufficientChangeException extends Exception {

private String message = "Sorry InsufficientChangeException O-O";
	
	public InsufficientChangeException(Error error) {
		super(error);
	}
	public String getErrorMessage() {
		return message;
	}
}
