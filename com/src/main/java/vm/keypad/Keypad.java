package vm.keypad;

import java.util.ArrayList;
import java.util.List;

import vm.emulator.KeypadButton;
import vm.impl.VendingMachineImpl;
import vm.util.DisplayMessage;

public class Keypad {
	private List<KeypadButton> buttonsSelected;
	private VendingMachineImpl snackVM;
	
	public Keypad() {
		this.snackVM = null;
		this.buttonsSelected = new ArrayList<KeypadButton>();

	}
	public Keypad(VendingMachineImpl vm) {
		snackVM = vm;

	}
	public int PressKeypad(KeypadButton button)
	{
		DisplayMessage ds = snackVM.getDisplayMessage(); 
		ds.appendMessage(button.getName());
		if (button.getNum() == KeypadButton.ENTER.getNum()) {
			//TODO : GoTo idle state
		}
		if (button.getNum() == KeypadButton.CLR.getNum()) {
			ds.clear();
		}
		return button.getNum();
	}
	
}
