package vm.emulator;
/**
 * enum represent four dimonstrations of coinSlot
 * 
 * @author lailaShreteh
 *
 */
public enum CoinSlot {
	COIN_10("COIN_10",10),
	COIN_20("COIN_20",20),
	COIN_50("COIN_50",50),
	COIN_ONE_$("COIN_ONE_$",100);
	
	private String name;
	private long dimonstration;
	
	private CoinSlot (String name, long dimonstration) {
		this.name = name;
		this.dimonstration = dimonstration;
	}
	
	public long getDimonstration()
	{
		return dimonstration;
	}
	
	public String getName() {
	   	return name;
	}
	public static String getClassName()
	{
		return "CoinSlot";
	}
	  @Override
	   public String toString() {
	        return "Coin >>> "+name+" (" + dimonstration + "$)";
	    }
	
}
