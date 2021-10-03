package vm.state;

import vm.Payment;
import vm.emulator.Snack;
import vm.exceptions.FullCapacityForSnack;
import vm.impl.VendingMachineImpl;
import vm.util.DisplayMessage;

public class OutOfStockState implements State{
	DisplayMessage ds = new DisplayMessage("");
	public void insertMoney(VendingMachineImpl vm, Payment moneySlot) {
		vm.doReturnMoney();
		// nth to be done!
	}

	public void ejectMoney(VendingMachineImpl vm) {
		vm.doReturnMoney();		
	}

	public void dispenseSnack(VendingMachineImpl vm) {
		
	}

	public void refillSnack(VendingMachineImpl vm,Snack snack,int count) {
		ds.display("refill snacks");
		if (vm.getSnackPocket().getElement(snack) < vm.getCapacity()) {
		       vm.getSnackPocket().put(snack, count);
			} else {  
			  throw new FullCapacityForSnack(new Error("FullCapacityForSnack O_o"));
			}
		// both cases should go to idle
		vm.setState(vm.getIdleState());	
	}
	public String toString() {
		 return "OutOfStockState O_o";
	}
		
}