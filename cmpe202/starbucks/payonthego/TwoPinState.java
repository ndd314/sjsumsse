package payonthego;

public class TwoPinState implements PasscodeState {
	
	private static TwoPinState instance;
	private final int MY_STATE = 2;
	private String passcode;
	
	TwoPinState() {
	}
	
	public static TwoPinState getInstance() {
		if (null==instance)
			instance = new TwoPinState();
		return instance;
	}

	
	public PasscodeState backspace() {
		// TODO Auto-generated method stub
		return OnePinState.getInstance();
	}

	
	public PasscodeState number(String input) {
		// TODO Auto-generated method stub
		ThreePinState state = ThreePinState.getInstance();
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
