package vm.impl;

import org.apache.commons.lang3.EnumUtils;

import vm.Payment;
import vm.emulator.CoinSlot;
import vm.emulator.MoneySlot;
import vm.exceptions.FullCapacityForSnack;
import vm.exceptions.NotAcceptedDenominations;

public class PaymentCoinImpl extends Payment{
	private CoinSlot coin;
	
	public PaymentCoinImpl(CoinSlot coin) {
		this.coin = coin;
		setPaymentMethod();
	}
	@Override
	public long getChange() {
		return coin.getDimonstration();
	}

	@Override
	public void setPaymentMethod() {
		super.paymentMethod = coin.getName();
	}

	@Override
	public boolean isAcceptedDenominations(String value) {
		return EnumUtils.isValidEnum(CoinSlot.class, value);
	}


	public void checkCoin(long coin) throws NotAcceptedDenominations {
		if (isAcceptedDenominations(this.coin.getName())) {
			
		} else {
			 throw new NotAcceptedDenominations(new Error("NotAcceptedDenominations O_o"));
		}
	}
	
	@Override
	public long getAmount() {
		return coin.getDimonstration();
	}
	@Override
	public String getPaymentMethod() {
		return this.paymentMethod;
	}
	
}
