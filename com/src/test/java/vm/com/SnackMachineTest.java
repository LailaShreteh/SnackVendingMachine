package vm.com;

import vm.Payment;
import vm.VendingMachineFactory;
import vm.emulator.Snack;
import vm.exceptions.FullCapacityForSnack;
import vm.exceptions.NotAcceptedDenominations;
import vm.exceptions.SoldOutExp;
import vm.impl.PaymentCoinImpl;
import vm.impl.PaymentNoteImpl;
import vm.impl.VendingMachineImpl;
import vm.keypad.Keypad;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import vm.emulator.*;


/**
 * Unit test for simple App.
 */
public class SnackMachineTest 
{
	@Rule
	 public TestName name= new TestName();
    private static VendingMachineImpl vm;
    
   @BeforeClass
   public static void setUp() throws NotAcceptedDenominations {
	   vm = (VendingMachineImpl) VendingMachineFactory.createVendingMachine();
	   // fill in the machine before
	   
   }
   
   @AfterClass
   public static void tearDown() {
	   System.out.println("my state afterAllTests: "+vm.getState());
	   vm = null;
   }
   
   @Before
   public void beforeTest() {
	   vm.reset();
	   System.out.println("++++++++++++++++"+name.getMethodName()+"++++++++++++++++");
	   System.out.println("My state before: "+vm.getState());
	   System.out.println("My total Revenue: "+vm.getTotalRevenue());
   }
   @After
   public void afterTest() {
	   System.out.println("My state afterOneTest: "+vm.getState().toString());
	   System.out.println("########################################");
 
   }
   @Test
   public void testHappySenarioWithCoin() {
	   // first fill in snack to machine
	   fillMyVm(10);
	   // wants to purchase snack
	   // press at keypad
	   Keypad key = new Keypad();
	   vm.getSnackPrice(Snack.COKE);
	   vm.setCurrentSnackSlot(Snack.COKE);
	   //The customer inserts the money.
	   Payment coin = new PaymentCoinImpl(CoinSlot.COIN_50);
	   vm.insertMoney(coin);
	   //System.out.println(vm.getMoneyPocket().hasElement(new PaymentCoinImpl(CoinSlot.COIN_20)));
	  // assertTrue();
	   //printWhatInsideMyVM();	   
   }
   @Test
   public void testHappySenarioWithNote() {
	// first fill in snack to machine
	   fillMyVm(10);
	   vm.setTotalRevenue(60000);
	   // wants to purchase snack
	   // press at keypad
	   Keypad key = new Keypad();
	   vm.getSnackPrice(Snack.CHOCLATEPAR);
	   vm.setCurrentSnackSlot(Snack.CHOCLATEPAR);
	   //The customer inserts the money.
	   Payment note = new PaymentNoteImpl(NoteSlot.DOLAR_50);
	   vm.insertMoney(note);
	   //printMoneyPocket();	 
   }
   @Test
   public void testUnHappySenario() {
	   // first fill in VM machine
   }
   @Test(expected = SoldOutExp.class)
   public void testPurchaseUnavialableSnack() {
	   //before adding any snack to VM
	   //printWhatInsideMyVM();
	   vm.getSnackPrice(Snack.CANDY);
   }
   @Test(expected = FullCapacityForSnack.class)
   public void testFullCapacityFromSameSnack() {
	   // 1- machine is in idle state try ask for one item price
	   //printWhatInsideMyVM();
	   vm.setCapacity(10);
	   vm.refillSnack(Snack.CHIPS, 10);
	   vm.refillSnack(Snack.CHIPS, 1);
	   //printWhatInsideMyVM();
   }
   @Test
   public void testInsertToMoneyPocketCaseIdleState() {
	   // 1- machine is in idle state try ask for one item price
	   //printWhatInsideMyVM();
	   vm.refillSnack(Snack.CANDY, 3);
	   vm.refillSnack(Snack.CHIPS, 10);
	   vm.getSnackPrice(Snack.CANDY);
	   //printWhatInsideMyVM();
   }
   public void fillMyVm(int capacity) {
	   vm.setCapacity(capacity);
	   vm.refillSnack(Snack.CHIPS, capacity);
	   vm.refillSnack(Snack.CANDY, capacity);
	   vm.refillSnack(Snack.CHOCLATEPAR, capacity);
	   vm.refillSnack(Snack.COKE, capacity);
	   vm.refillSnack(Snack.COOKIES, capacity);
	   vm.refillSnack(Snack.NUTS, capacity);
	   
   }
   /*public void printWhatInsideMyVM() {
	    
	   
	   
   }*/
   public void printSnackPocket() {
	   String str = vm.getSnackPocket().toString();
	   if(str == "") {
		   System.out.println("EMPTY Snack Pocket VM Machine O_o");
	   } else {
		   System.out.println(str);
	   }
   }
   public void printMoneyPocket() {
	   String str_ = vm.getMoneyPocket().toString();
	   if(str_ == "") {
		   System.out.println("EMPTY Money Pocket VM Machine O_o");
	   } else {
		   System.out.println(str_);
	   }
   }
}
