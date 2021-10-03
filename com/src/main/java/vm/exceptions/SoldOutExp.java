package vm.exceptions;

import javax.management.RuntimeErrorException;
/**
 * Soldout Exception error handling
 * @author lailaShreteh
 *
 */
public class SoldOutExp extends RuntimeErrorException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "Sorry element Sold Out X_X, plz try purchase another one :D";
	
	public SoldOutExp(Error error) {
		super(error);
	}
	public String getErrorMessage() {
		return message;
	}
}
