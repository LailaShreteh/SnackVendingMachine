package vm.util;
/**
 * 
 * @author lailaShreteh
 *
 */
public class DisplayMessage {
	
	private String message;

	public DisplayMessage(String message) {
		this.setMessage(message);
		System.out.println(message);
	}
	public void display(String message) {
		System.out.println(message);
	}
	String getMessage() {
		return message;
	}

	void setMessage(String message) {
		this.message = message;
	}
	public void clear() {
		message = "";
	}
	public void appendMessage(String message) {
		this.message+= message;
		display(this.message);
	}

}
