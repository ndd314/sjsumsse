package payonthego;
/**
 * 
 */

/**
 * @author dnguyen
 *
 */
public class KeyPad {
	// implement as a Singleton
	
	private static KeyPad instance;
	
	final private String[][] keyMap = {
			{"1","2","3"},
			{"4","5","6"},
			{"7","8","9"},
			{null, "0", "b"} };
	
	public KeyPad() {
		// constructor
	}
	
	public static KeyPad getInstance() {
		if (instance==null)
			instance = new KeyPad();
		return instance;
	}
	
	public String keyPressed(int x, int y){
		return keyMap[y-1][x-1];
	}
}
