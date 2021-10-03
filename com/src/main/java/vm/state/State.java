package vm.state;

import vm.Payment;
import vm.emulator.Snack;
import vm.impl.VendingMachineImpl;

public interface State {
public void insertMoney (VendingMachineImpl vm,Payment moneySlot);
public void ejectMoney (VendingMachineImpl vm);
public void dispenseSnack (VendingMachineImpl vm);
public void refillSnack(VendingMachineImpl vm,Snack snack,int count);
}
