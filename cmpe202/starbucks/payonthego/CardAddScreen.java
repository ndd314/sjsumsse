package payonthego;

public class CardAddScreen implements Screen, TouchHandler {
	public final String screenTitle = "Add Card Screen";
	
	private final int MAX_CARDID_LENGTH = 16;
	private final int MAX_CARDCODE_LENGTH = 8;
	private final double DEFAULT_CARD_BALANCE = 16.50;
	
	NumberInputWidget cardIDWidget;
	NumberInputWidget cardCodeWidget;
	NumberInputWidget focusInput;
	
	CardAddScreen() {
		cardIDWidget = new NumberInputWidget();
		cardIDWidget.setMaxLength(MAX_CARDID_LENGTH);
		
		cardCodeWidget = new NumberInputWidget();
		cardCodeWidget.setMaxLength(MAX_CARDCODE_LENGTH);
		
		// default focusing on cardID
		focusInput = cardIDWidget;
	}
	
	
	public void touch(int x, int y) {
		if (y==3) {
			// touching card ID input box
			focusInput = cardIDWidget;
		} else if (x==2 && y==4) {
			// touch card code input box
			focusInput = cardCodeWidget;
		} else if (y >= 5) {
			// touching key pad
			focusInput.touch(x, y);
		}
	}

	
	public String display() {
		String display = "Enter a new Card";
		System.out.println(display);
		return display;
	}

	
	public void topLeftCommand() {
		// Cancel back to Settings Screen
		AppController.getInstance().menu5();
	}

	
	public void topRightCommand() {
		// Add Card Command
		String cardID = this.cardIDWidget.getInput();
		String cardCode = this.cardCodeWidget.getInput();
				
		if (cardID.length()==MAX_CARDID_LENGTH && cardCode.length()==MAX_CARDCODE_LENGTH) {
			User user = User.getInstance();
			user.myCard.setCardID(cardID);
			user.myCard.setCardCode(cardCode);
			user.myCard.setCardBalance(DEFAULT_CARD_BALANCE);
			AppController.getInstance().menu5(); // back to setting screen
		} else {
			// error not enough input
			System.out.println("Invalid Card ID or Card Code");
		}
	}
	
	
	public String getScreenTitle() {
		return screenTitle;
	}

}
