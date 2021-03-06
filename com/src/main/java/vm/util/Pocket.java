package vm.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * class to map cash or snacks inside vm 
 * @author lailaShreteh
 *
 */
public class Pocket<T> {
	private Map<T, Long> pocket = new HashMap<T, Long>(); 
	
	public void put(T element, long amount) {
		pocket.put(element, amount);
	}
	public boolean hasElement(T element) {
		return (getElement(element) > 0);
	}
	public long getElement(T element) {
		 Long remainingAmount = pocket.get(element);
		 return remainingAmount == null? 0:remainingAmount;
	}
	public void add(T element) {
		if (pocket.get(element) != null) {
			pocket.put(element,pocket.get(element)+1);
		} else {
			pocket.put(element,new Long(1));
		}
	}
	public void dispense(T element) {
		if (hasElement(element))
			pocket.put(element,pocket.get(element)-1);
	}
	public void clearAll()
	{
		pocket.clear();
	}
	public boolean isEmpty() {
		return pocket.size() == 0 ? true:false;
	}
	public String toString() {
		String str = "";
		 for (Entry<T, Long> entry : pocket.entrySet()) {
			 if (entry.getValue() > 0) {
			    str= str + entry.getKey() + ":\t(" + entry.getValue().toString()+")pisces\n\r";
			 }
			}
		 return str;
	}
}
