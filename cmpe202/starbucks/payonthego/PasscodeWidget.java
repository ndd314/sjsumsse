package payonthego;

public class PasscodeWidget extends Widget implements TouchHandler, AuthenticatedState {
	private String passcode;
	private KeyPadScreenAdapter keypad;
	private PasscodeState currentState;
	private boolean authenticatedState = false;
	
	public PasscodeWidget() {
		keypad = new KeyPadScreenAdapter(0,4);
		currentState = NoPinState.getInstance();
		EchoObscurePasscode echoAsterisk = new  EchoObscurePasscode();
		this.attachObserver("echo", echoAsterisk);
	}
	
	public boolean getAuthenticatedState() {
		return this.authenticatedState;
	}

	
	public void touch(int x, int y) {
		// TODO Auto-generated method stub
		String input = keypad.keyPressed(x, y);
		if (null!=input) {
			if (input.equals("b")) {
				currentState = currentState.backspace();
			} else {
				currentState = currentState.number(input);
			}
			
			this.passcode = currentState.getPasscode();
			this.notifyObserver(passcode);
			
			if (currentState.getState() == 4) {
				User user = User.getInstance();
				if (user.isPasscodeMatch(passcode)) {			
					this.authenticatedState = true;
				} else {
					currentState = NoPinState.getInstance();
					this.passcode = currentState.getPasscode();
					this.notifyObserver(passcode);
				}
			}
		}
	}
	
	public int getPasscodeState() {
		return currentState.getState();
	}
}
