package payonthego;

public class CardOptionScreen implements Screen, TouchHandler {
	
	public final String screenTitle = "My Cards - Options";
	
	
	public void touch(int x, int y) {
		// display more options screen when touch (1,7), (2,7), (3,7)
		if (y==7) {
			AppController app = AppController.getInstance();
			app.displayCardMoreOptionScreen();
		}
	}

	
	public String display() {
		String display = "Reload, Refresh Balance, or More Options";
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
