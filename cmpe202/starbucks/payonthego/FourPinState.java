package payonthego;

public class FourPinState implements PasscodeState {
	
	private static FourPinState instance;
	private final int MY_STATE = 4;
	private String passcode;
	
	FourPinState() {
	}
	
	public static FourPinState getInstance() {
		if (null==instance) 
			instance = new FourPinState();
		return instance;
	}

	
	public PasscodeState backspace() {
		// TODO Auto-generated method stub
		return ThreePinState.getInstance();
	}

	
	public PasscodeState number(String input) {
		// TODO Auto-generated method stub
		// validate the passcode
		return instance;

	}
	
	public void setPasscode(String input) {
		this.passcode = input;
	}
	
	public String getPasscode() {
		return this.passcode;
	}

	
	public int getState() {
		// TODO Auto-generated method stub
		return MY_STATE;
	}

}
