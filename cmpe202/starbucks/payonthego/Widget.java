package payonthego;
import java.util.HashMap;
import java.util.Iterator;


public class Widget {
	HashMap<String, InputObserver> observers;
	
	Widget() {
		observers = new HashMap<String, InputObserver>();
	}
	
	public void attachObserver(String observerName, InputObserver observer) {
		observers.put(observerName, observer);
	}
	
	public void detachObserver(String observerName) {
		observers.remove(observerName);
	}
	
	public void notifyObserver(String display) {
		for (Iterator<String> i = observers.keySet().iterator(); i.hasNext();) { 
			String observerName = i.next();
			InputObserver observer = observers.get(observerName);
			observer.update(display);
		}
	}

}
