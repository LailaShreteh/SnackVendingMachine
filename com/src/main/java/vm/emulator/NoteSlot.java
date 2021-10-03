package vm.emulator;
/**
 * kinds of Notes slot accepted in VM machine
 * @author lailaShreteh
 *
 */
public enum NoteSlot {
	DOLAR_20(2000),
	DOLAR_50(5000);
	
	private int cash;
	
	private NoteSlot(int cash)
	{
		this.cash = cash;
	}
	public int getCash()
	{
		return cash;
	}
	
	  @Override
	    public String toString() {
	        return "moneyNote >>> (" + cash + "$)";
	    }
}
