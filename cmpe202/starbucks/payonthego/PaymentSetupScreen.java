package payonthego;

public class PaymentSetupScreen implements Screen, TouchHandler {
	
	public final String screenTitle = "Payment Setup";
	
	
	public void touch(int x, int y) {
		// TODO Auto-generated method stub

	}

	
	public String display() {
		String display = "Enable Payments?";
		System.out.println(display);
		return display;
	}

	
	public void topLeftCommand() {
		// TODO Auto-generated method stub

	}

	
	public void topRightCommand() {
		// TODO Auto-generated method stub

	}
	
	
	public String getScreenTitle() {
		return screenTitle;
	}

}
