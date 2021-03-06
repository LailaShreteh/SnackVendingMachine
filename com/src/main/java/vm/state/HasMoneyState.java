package vm.state;

import vm.Payment;
import vm.emulator.Snack;
import vm.exceptions.SoldOutExp;
import vm.impl.VendingMachineImpl;
import vm.util.DisplayMessage;

public class HasMoneyState implements State{
DisplayMessage ds = new DisplayMessage("");
	public void insertMoney(VendingMachineImpl vm,Payment moneySlot) {
		ds.display("have money !");
		vm.setCurrentMoneySlot(moneySlot);
		// 1- change balance
		vm.setBalance((long) (vm.getBalance()+vm.getCurrentMoneySlot().getAmount()));
		// 2- change Money pocket
		vm.getMoneyPocket().put(vm.getCurrentMoneySlot(),(long) vm.getCurrentMoneySlot().getAmount());	
		// 3- displays the accumulated amount of money each time a new money is entered.
		ds.display("Accumulated amount of money: "+vm.getBalance());
		/*vm.setCurrentMoneySlot(moneySlot);
		vm.setBalance(vm.getBalance() + vm.getCurrentMoneySlot().getAmount());
		vm.getMoneyPocket().add(vm.getCurrentMoneySlot());	
		ds.display("Accumulated amount of money: "+vm.getBalance());*/
	}

	public void ejectMoney(VendingMachineImpl vm) {
		ds.display("Ejecting Money X_X");
		vm.doReturnMoney();
		vm.setState(vm.getIdleState());
		
	}

	public void dispenseSnack(VendingMachineImpl vm) {
		if (vm.isFullPaid() && vm.getSnackPocket().getElement(vm.getCurrentSnackSlot()) >= 1 && vm.hasSufficientRevenue()) {
			new DisplayMessage("dispense Snack");
			vm.doReleaseSnack();
			vm.doRefund();
			vm.setState(vm.getIdleState());
		} else if (vm.getSnackPocket().hasElement(vm.getCurrentSnackSlot()) && (vm.getSnackPocket().getElement(vm.getCurrentSnackSlot()) <= 1)){
			if (vm.getSnackPocket().getElement(vm.getCurrentSnackSlot()) == 0) {
				vm.setState(vm.getOutOfStackState());
				throw new SoldOutExp(new Error("soldout O_o"));
			} else {
				vm.doReleaseSnack();
				vm.setState(vm.getOutOfStackState());
			}
		} else if (! vm.isFullPaid()){
			//stay at the same state
			new DisplayMessage("Accumulated amount of money: "+ vm.getBalance());
		}

}

	public void refillSnack(VendingMachineImpl vm, Snack snack, int count) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		 return "HasMoneyState O_o";
	}

}
