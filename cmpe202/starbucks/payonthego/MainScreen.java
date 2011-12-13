package payonthego;

public class MainScreen implements Screen, TouchHandler {
	
	public final String screenTitle = "Main Screen";
	
	
	public void touch(int x, int y) {
		if (x==3 && y==3) {
			AppController app = AppController.getInstance();
			app.displayCardPayScreen();
		} else if (x==2 && y==4) {
			AppController app = AppController.getInstance();
			app.displayCardOptionScreen();
		}

	}

	
	public String display() {
		User user = User.getInstance();
		double balance = user.myCard.getCardBalance();
		String display = String.format("$%.2f", balance);
		
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
