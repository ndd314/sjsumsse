package payonthego;

public class SettingScreen implements Screen, TouchHandler {
	
	public final String screenTitle = "Settings Screen";
	
	
	public void touch(int x, int y) {
		// display add card screen when touch (1,2), (2,2), (3,2)
		if (y==2) {
			AppController app = AppController.getInstance();
			app.displayCardAddScreen();
		}
	}

	
	public String display() {
		String display = "Manage Card, Billing, Passcode. Show About & Terms.";
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
