package vm.emulator;
/**
 * 
 * @author lailaShreteh
 *
 */
public enum KeypadButton {
	A("A",10),
	B("B",11),
	C("C",12),
	D("D",13),
	E("E",14),
	F("F",15),
	STAR("*",16),
	CLR("CLR",17),
	ENTER("ENTER",18),
	ONE("1",1),
	TWO("2",2),
	THREE("3",3);

	//etc ...
	
	
	String name;
	int num;
	private KeypadButton(String name,int num) {
		this.name = name;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
