package vm.emulator;
/**
 * 
 * Enum to represent Types served by Vending Machine
 *
 * @author lailaShreteh
 *
 */
public enum VMTypes { 
	COFFEE("Coffee"),
	DRINKS("Drinks"),
	SNACKS("Snacks");
	
	private String name;
	
	private VMTypes(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
}
