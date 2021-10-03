package vm.emulator;
/**
 *
 * Snacks provided by the Vending Machine
 * @author lailaShreteh
 *
 */
public enum Snack {// snack we have in Vending machine
	CHIPS("Chips",5),
	COKE("Coke",10),
	CHOCLATEPAR("ChoclatePar",10),
	COOKIES("Cookies",20),
	CANDY("Candy",15),
	NUTS("Nuts",25);
	// etc ....
	
	private String name;
	private long price;
	
    private Snack (String name,long price) {
    	this.name = name;
    	this.price = price;
    	
    }
    public String getName() {
    	return name;
    }
    public long getPrice() {
    	return price;
    }
    
    @Override
    public String toString() {
        return "snack >>> " + name + "(" + price+"$)";
    }
}

