package vm;

import vm.exceptions.NotAcceptedDenominations;
import vm.impl.VendingMachineImpl;

/**
 * 
 * Abstract class to create different kinds of Vending Machine
 * 
 * @author lailaShreteh
 *
 */
public abstract class VendingMachineFactory {
	public static VendingMachine createVendingMachine() throws NotAcceptedDenominations {
        return new VendingMachineImpl();
    }
}
