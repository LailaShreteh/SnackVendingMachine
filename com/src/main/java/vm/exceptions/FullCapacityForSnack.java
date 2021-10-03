package vm.exceptions;

import javax.management.RuntimeErrorException;
/**
 * Exception for full capacity in same col and raw let's say same lind of snack
 * @author lailaShreteh
 *
 */
public class FullCapacityForSnack extends RuntimeErrorException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7782811326375898504L;
	private String message = "Sorry Full capacity of same snack, can't fill any more X_X";
	
	public FullCapacityForSnack(Error error) {
		super(error);
	}
	public String getErrorMessage() {
		return message;
	}
}
