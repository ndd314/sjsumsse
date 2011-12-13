package payonthego;

public class User {
	private static User instance;
	private String userPasscode;
	public RewardCard myCard;
	
	User() {
		myCard = new RewardCard();
	}
	
	public static User getInstance() {
		if (null==instance)
			instance = new User();
		return instance;
	}
	
	public void setUserPasscode(String userPasscode) {
		this.userPasscode = userPasscode;
	}
	
	public boolean isPasscodeMatch(String input) {
		return userPasscode.equals(input);
	}
}
