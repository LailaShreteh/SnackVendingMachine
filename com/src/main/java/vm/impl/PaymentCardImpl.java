package vm.impl;

import vm.Payment;

public class PaymentCardImpl extends Payment{
	
	@Override
	public long getChange() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPaymentMethod() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptedDenominations(String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getPaymentMethod() {
		return this.paymentMethod;
	}
}
