package payonthego;

public class NumberInputWidget extends Widget implements TouchHandler {
	private int maxLength = 16;
	private KeyPadScreenAdapter keypad;
	private String input = "";
	
	public NumberInputWidget() {
		keypad = new KeyPadScreenAdapter(0,4);		
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	
	public void touch(int x, int y) {
		String digit = keypad.keyPressed(x, y);
		if (null!=input) {
			if (digit.equals("b")) {
				// trim one at the end if possible
				if (input.length() > 0) {
					input = input.substring(0, input.length()-1);
				}
			} else if (this.input.length() < this.maxLength) {
				input = input + digit;
			}
		}
	}

}
