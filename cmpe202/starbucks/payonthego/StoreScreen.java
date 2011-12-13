package payonthego;

public class StoreScreen implements Screen, TouchHandler {
	
	public final String screenTitle = "Find Starbucks";
	
	
	public void touch(int x, int y) {
		// TODO Auto-generated method stub

	}

	
	public String display() {
		String display = "Google Map of Local Starbucks";
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
