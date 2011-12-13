package payonthego;

public class NoPinState implements PasscodeState {
	
	private static NoPinState instance;
	private final int MY_STATE = 0;
	private final String passcode = "";
	
	NoPinState() {
	}
	
	public static NoPinState getInstance() {
		if (instance==null)
			instance = new NoPinState();
		return instance;
	}

	
	public PasscodeState backspace() {
		// TODO Auto-generated method stub
		return instance;
	}

	
	public PasscodeState number(String input) {
		// TODO Auto-generated method stub
		OnePinState state = OnePinState.getInstance();
		state.setPasscode(input);
		return state;

	}
	
	public String getPasscode() {
		return this.passcode;
	}

	
	public int getState() {
		// TODO Auto-generated method stub
		return MY_STATE;
	}
}
