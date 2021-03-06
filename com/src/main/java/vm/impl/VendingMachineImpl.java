package vm.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import vm.Payment;
import vm.VendingMachine;
import vm.emulator.CoinSlot;
import vm.emulator.MoneySlot;
import vm.emulator.NoteSlot;
import vm.emulator.Snack;
import vm.exceptions.FullCapacityForSnack;
import vm.exceptions.InsufficientChangeException;
import vm.exceptions.NotAcceptedDenominations;
import vm.exceptions.SoldOutExp;
import vm.keypad.Keypad;
import vm.state.HasMoneyState;
import vm.state.IdleState;
import vm.state.OutOfStockState;
import vm.state.State;
import vm.util.DisplayMessage;
import vm.util.Pocket;

/**
 * 
 * Implementation of VendingMachine interface
 *
 * @author LailaShreteh
 *
 */
public class VendingMachineImpl implements VendingMachine
{
	String id;
	long balance;
	Snack snack;
	private Pocket<Payment> moneyPocket = new Pocket<Payment>();
	private Pocket<Snack> snackPocket = new Pocket<Snack>();
	int capacity;
	Keypad keypad;
	private long totalRevenue;
	private Snack currentSnackSlot;
    private Payment currentMoneySlot;
	private DisplayMessage ds;
	private State currentState;
	private State idleState;
	private State hasMoneyState;
	private State outOfStockState;
	private Pocket<Payment> moneyPocket_global = new Pocket<Payment>(); 

	public VendingMachineImpl() throws NotAcceptedDenominations {
		// initialize vm with some money to dispenses change
		inistializeVM();
	}
	public void inistializeVM () throws NotAcceptedDenominations {
        idleState = new IdleState();
        hasMoneyState = new HasMoneyState();
        outOfStockState = new OutOfStockState();
        if (! snackPocket.isEmpty()) {
        	currentState = idleState;
        } else {
        	currentState = outOfStockState;
        }
		this.id = "UDI_LAILATest";
        this.capacity = 10;
        this.keypad = new Keypad();
        this.totalRevenue = 1000;
        this.currentSnackSlot = null;
        this.currentSnackSlot = null;
        this.balance = 0;
        this.ds = new DisplayMessage("");
       /* PaymentCardImpl card = new PaymentCardImpl();
        PaymentCoinImpl coin = new PaymentCoinImpl();
        coin.setCoin(10);
        PaymentNoteImpl note = new PaymentNoteImpl();
        note.setMoney(20);
		moneyPocket.put(coin,3);
		moneyPocket.put(note,5);
		snackPocket.put(Snack.CANDY,10);
		snackPocket.put(Snack.CHIPS, 5);*/
		
	}
	/*public void Process () {
		
	}*/
	public void setTotalRevenue(long value) {
        this.totalRevenue = value;
	}
	public long getTotalRevenue() {
			return totalRevenue;
	}
	
	public void refillChange(Payment value,int MoneyInit){
		moneyPocket.put(value,MoneyInit);
	}
	
	public long getSnackPrice(Snack snack) {
		if (snackPocket.hasElement(snack)) {
			this.snack = snack;
			ds.display("Snack: "+snack.getName()+" available :D \r\n Price: "+snack.getPrice());
			return snack.getPrice();
		} else {
			throw new SoldOutExp(new Error("soldout O_o"));
		}
	}
	
	public Map<Payment,Integer> doRefund() {
		ds.display("refund :\n\r");
		Map<Payment,Integer> refund = getChange(balance);
		String str = "";
		 for (Entry<Payment, Integer> entry : refund.entrySet()) {
			 if (entry.getValue() > 0) 
			    str= str + entry.getKey().paymentMethod + ":\t(" + entry.getValue().toString()+")pisces\n\r";
			}
		 ds.display(str);
		 this.reset();
		return refund;
	}
	private Map<Payment,Integer> getChange(long remaingMoney) {
		long currentPriceSnack = currentSnackSlot.getPrice();
		balance -= currentPriceSnack;
		Map<Payment,Integer> refund = new HashMap<>(); 

		   int remainingAmount = (int)remaingMoney;
		   // case1 : 50 , 1 // 20,3 // 10,5
		   //
		   Payment Dolar_50 = new PaymentNoteImpl(NoteSlot.DOLAR_50);
	       refund.put(Dolar_50,remainingAmount / NoteSlot.DOLAR_50.getCash());
	       remainingAmount = (int) (new Double(remainingAmount) % (NoteSlot.DOLAR_50.getCash()));
	        
	       Payment Dolar_20 = new PaymentNoteImpl(NoteSlot.DOLAR_20);
	       refund.put(Dolar_20,remainingAmount / NoteSlot.DOLAR_20.getCash());
	       remainingAmount = (int) (new Double(remainingAmount) % (NoteSlot.DOLAR_20.getCash()));

		  Payment One_Coin_$ = new PaymentCoinImpl(CoinSlot.COIN_ONE_$);
	      refund.put(One_Coin_$,remainingAmount / (int)(CoinSlot.COIN_ONE_$.getDimonstration()));
	      remainingAmount = remainingAmount % (int)(CoinSlot.COIN_ONE_$.getDimonstration());

			Payment Coin_50 = new PaymentCoinImpl(CoinSlot.COIN_50);
	        refund.put(Coin_50,(int) (new Double(remainingAmount) / (CoinSlot.COIN_50.getDimonstration())));
	        remainingAmount = (int) (new Double(remainingAmount) % (CoinSlot.COIN_50.getDimonstration()));

	        Payment Coin_20 = new PaymentCoinImpl(CoinSlot.COIN_20);
	        refund.put(Coin_20,(int) (new Double(remainingAmount) / (CoinSlot.COIN_20.getDimonstration())));
	        remainingAmount = (int) (new Double(remainingAmount) % (CoinSlot.COIN_20.getDimonstration()));

	        Payment Coin_10 = new PaymentCoinImpl(CoinSlot.COIN_10);
	        refund.put(Coin_10,(int) (new Double(remainingAmount) /(CoinSlot.COIN_10.getDimonstration())));
	       // remainingAmount = (int) (new Double(remainingAmount) % (CoinSlot.COIN_10.getDimonstration()));		
		
				
		return refund;
	}
	
	public void reset() {
		moneyPocket.clearAll();
		snackPocket.clearAll();
		balance = 0;
		snack = null;
		currentSnackSlot = null;
		currentMoneySlot = null;		
	}

	public boolean isFullPaid() {
		return (balance >= currentSnackSlot.getPrice());
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public State getHasMoneyState() {
		return hasMoneyState;
	}
	public Snack getCurrentSnackSlot() {
		return currentSnackSlot;
	}
	public void setCurrentSnackSlot(Snack currentSnackSlot) {
		this.currentSnackSlot = currentSnackSlot;
	}
	public Payment getCurrentMoneySlot() {
		return currentMoneySlot;
	}
	public void setCurrentMoneySlot(Payment currentMoneySlot) {
		this.currentMoneySlot = currentMoneySlot;
	}
	public Pocket<Payment> getMoneyPocket() {
		return moneyPocket;
	}
	public void setMoneyPocket(Pocket<Payment> moneyPocket) {
		this.moneyPocket = moneyPocket;
	}
	public Pocket<Snack> getSnackPocket() {
		return snackPocket;
	}
	public void setSnackPocket(Pocket<Snack> snackPocket) {
		this.snackPocket = snackPocket;
	}
/*	public Snack ProcessingRequest(Snack snackSellected) {
		if (! snackPocket.hasElement(snackSellected)){
			throw new SoldOutExp(new Error("soldout O_o"));
		} 
		this.currentSnackSlot = snackSellected;
		setState(new HasMoneyState());
		
		return currentSnackSlot;
	}*/
	public State getIdleState() {
		return idleState;
	}
	public void doReturnMoney() {
		this.moneyPocket.dispense(currentMoneySlot);	
	}
	public void doReleaseSnack() {
		snackPocket.dispense(currentSnackSlot);
		this.setBalance(balance - currentSnackSlot.getPrice());
	}
	public State getOutOfStackState() {
		return outOfStockState;
	}
	public void insertMoney(Payment MoneySlot) {
		this.setCurrentMoneySlot(MoneySlot);
		currentState.insertMoney(this,MoneySlot);
	}
	public void ejectMoney () {
		currentState.ejectMoney(this);
	}
	public void dispenseSnack () {
		currentState.dispenseSnack(this);
	}
	public void refillSnack (Snack snack,int count) {
		currentState.refillSnack(this,snack,count);
	}
	public State getState() {
		return currentState;
	}
	public void setState(State currentState) {
		this.currentState = currentState;
	}
	public DisplayMessage getDisplayMessage() {
		return ds;
	}
	public void setDisplayMessage(DisplayMessage ds) {
		this.ds = ds;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public boolean hasSufficientRevenue() {
		return (this.totalRevenue >= (balance-this.currentSnackSlot.getPrice()));
	}
}
