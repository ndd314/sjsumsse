package payonthego;

public class CardPayScreen implements Screen, TouchHandler {
	
	public final String screenTitle = "My Cards - Pay";
	
	
	public void touch(int x, int y) {
		if (x==3 && y==3) {
			AppController app = AppController.getInstance();
			app.menu1();
		} else if (y == 2) {
			// (1,2), (2,2), (3,2) trigger payment of $1.50 then return to main
			User user = User.getInstance();
			double balance = user.myCard.getCardBalance()-1.50;
			
			if ( balance >= 0) {
				user.myCard.setCardBalance(balance);
			} else {
				// display error
				System.out.println("Not enough balance available for this transaction of $1.50");
			}
			
			AppController app = AppController.getInstance();
			app.menu1();
		}

	}

	
	public String display() {
		String display = "Scan Now";
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
