package vm.impl;

import org.apache.commons.lang3.EnumUtils;

import vm.Payment;
import vm.emulator.MoneySlot;
import vm.emulator.NoteSlot;
import vm.exceptions.NotAcceptedDenominations;

public class PaymentNoteImpl extends Payment{
	private NoteSlot money;
	
	public PaymentNoteImpl(NoteSlot note) {
		money = note;
		setPaymentMethod();
	}
	@Override
	public long getChange() {
		return money.getCash();
	}

	@Override
	public void setPaymentMethod() {
		super.paymentMethod = money.name();
	}

	@Override
	public boolean isAcceptedDenominations(String value) {
		return EnumUtils.isValidEnum(NoteSlot.class, value);
	}
	
	@Override
	public long getAmount() {
		return money.getCash();
	}

	public void setMoney(long money) throws NotAcceptedDenominations {
		if (isAcceptedDenominations(money+"")) {
		} else {
			 throw new NotAcceptedDenominations(new Error("NotAcceptedDenominations O_o"));
		}
	}
	@Override
	public String getPaymentMethod() {
		return this.paymentMethod;
	}
}
