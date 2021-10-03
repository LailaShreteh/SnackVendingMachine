package vm.emulator;
/**
 * payment MoneySlot ways 
 * @author lailaShreteh
 *
 */
public enum MoneySlot {
	COINSLOT("CoinSlot"),
	CARDSLOT("CardSlot"),
	NOTESLOT("NoteSlot");
	
	private String name;
	
	private MoneySlot(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
