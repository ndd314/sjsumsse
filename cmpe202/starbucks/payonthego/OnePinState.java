package payonthego;

public class OnePinState implements PasscodeState {
	
	private static OnePinState instance = new OnePinState();
	private final int MY_STATE = 1;
	private String passcode;
	
	OnePinState() {
	}
	
	public static OnePinState getInstance() {
		return instance;
	}

	
	public PasscodeState backspace() {
		// TODO Auto-generated method stub
		return NoPinState.getInstance();
	}

	
	public PasscodeState number(String input) {
		// TODO Auto-generated method stub
		TwoPinState state = TwoPinState.getInstance();
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
