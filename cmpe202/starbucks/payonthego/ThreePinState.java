package payonthego;

public class ThreePinState implements PasscodeState {
	
	private static ThreePinState instance;
	private final int MY_STATE = 3;
	private String passcode;
	
	ThreePinState() {
	}
	
	public static ThreePinState getInstance() {
		if (null==instance)
			instance = new ThreePinState();
		return instance;
	}

	
	public PasscodeState backspace() {
		// TODO Auto-generated method stub
		return TwoPinState.getInstance();
	}

	
	public PasscodeState number(String input) {
		// TODO Auto-generated method stub
		FourPinState state = FourPinState.getInstance();
		state.setPasscode(passcode+input);
		return state;
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
