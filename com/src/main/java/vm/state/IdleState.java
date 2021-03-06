package vm.state;

import java.util.Map.Entry;

import vm.Payment;
import vm.emulator.Snack;
import vm.exceptions.FullCapacityForSnack;
import vm.impl.VendingMachineImpl;
import vm.util.DisplayMessage;
public class IdleState implements State {
	DisplayMessage ds = new DisplayMessage("");

	public void insertMoney(VendingMachineImpl vm,Payment moneySlot) {
		ds.display("money Inserted !");
		vm.setCurrentMoneySlot(moneySlot);
		vm.setBalance((vm.getBalance() + vm.getCurrentMoneySlot().getAmount()));
		vm.getMoneyPocket().add(vm.getCurrentMoneySlot());	
		ds.display("Accumulated amount of money: "+vm.getBalance());
		vm.setState(vm.getHasMoneyState());	
		vm.dispenseSnack();
	}

	public void ejectMoney(VendingMachineImpl vm) {
		ds.display("No money To return !");
	}

	public void dispenseSnack(VendingMachineImpl vm) {
		ds.display("Payment required !");
		
	}

	public void refillSnack(VendingMachineImpl vm,Snack snack, int count) {
		ds.display("refill snacks");
		if (vm.getSnackPocket().getElement(snack) < vm.getCapacity()) {
		       vm.getSnackPocket().put(snack, count);
			} else {  
			  throw new FullCapacityForSnack(new Error("FullCapacityForSnack O_o"));
			}
		// stay idle
	}
	public String toString() {
		 return "IdleState O_o";
	}
}
