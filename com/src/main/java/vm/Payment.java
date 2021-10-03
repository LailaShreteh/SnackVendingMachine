package vm;

import vm.emulator.CoinSlot;
import vm.emulator.MoneySlot;

/**
 * Abstract Class for diffrent types of money
 * @author lailaShreteh
 *
 */
public abstract class Payment {
	public String paymentMethod;
	public abstract long getChange();
	public abstract void setPaymentMethod();
	public abstract boolean isAcceptedDenominations(String value);
	public abstract long getAmount();
	public abstract String getPaymentMethod();
	public void setPaymentMethod(MoneySlot slot) {
		// TODO Auto-generated method stub
		
	}
}
