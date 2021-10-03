package vm.exceptions;
/**
 * Exception Invalid Payment method in case customer enters not USD currency
 * @author lailaShreteh
 *
 */
public class NotAcceptedDenominations extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 8655666187495144056L;
private String message = "Sorry Invalid payment method, Machine only accepts USD currency X_X";
	
	public NotAcceptedDenominations(Error error) {
		super(error);
	}
	public String getErrorMessage() {
		return message;
	}
}
