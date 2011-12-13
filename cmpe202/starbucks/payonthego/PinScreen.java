package payonthego;

public class PinScreen implements Screen, TouchHandler, AuthenticatedState {
	
	public final String screenTitle = "Pin Screen";
	private boolean authenticatedState = false;
	
	PasscodeWidget passcodeWidget;
	
	PinScreen() {
		// keypad origin start at 1,5 on the screen
		// so the offset is 0,4 respectively

		passcodeWidget = new PasscodeWidget();
	}
	
	public boolean getAuthenticatedState() {
		return this.authenticatedState;
	}
	
	
	public String display() {
		String display = screenTitle;
		System.out.println(display);
		return display;
	}

	
	public void topLeftCommand() {
		// TODO Auto-generated method stub

	}

	
	public void topRightCommand() {
		// TODO Auto-generated method stub

	}

	
	public void touch(int x, int y) {
		if (y > 4) {
			passcodeWidget.touch(x, y);
			this.authenticatedState = passcodeWidget.getAuthenticatedState();
		}
	}
	
	
	public String getScreenTitle() {
		return screenTitle;
	}
}
