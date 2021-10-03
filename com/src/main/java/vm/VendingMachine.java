package vm;

import java.util.Map;

import vm.emulator.MoneySlot;
import vm.emulator.Snack;

/**
 * 
 * Interface defines functions of vm
 * @author lailaShreteh
 *
 */
public interface VendingMachine {

	void insertMoney(Payment moneySlot);
	void ejectMoney();
	void dispenseSnack();
	
/*	public long getSnackPrice(Snack snack);
	public void insertMoneySlot(Payment moneySlot);
	public Map<Payment, Integer> refund();
	public void reset();
	*/
}
