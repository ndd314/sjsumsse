package payonthego;

public class CardMoreOptionScreen implements Screen, TouchHandler {
	
	public final String screenTitle = "My Cards More Options";
	
	
	public void touch(int x, int y) {
		// TODO Auto-generated method stub

	}

	
	public String display() {
		String display = "Refresh, Reload or View Recent Transactions";
		System.out.println(display);
		return display;
	}

	
	public void topLeftCommand() {
		// Cancel goes back to Option Screen
		AppController app = AppController.getInstance();
		app.displayCardOptionScreen();
	}

	
	public void topRightCommand() {
		// TODO Auto-generated method stub

	}
	
	
	public String getScreenTitle() {
		return screenTitle;
	}

}
