package payonthego;

public class EchoObscurePasscode implements InputObserver {

	
	public void update(String display) {
		String asterisks = "****";
		if (display.length() > 0)
			System.out.println("passcode: " + asterisks.substring(0, display.length()));
		else
			System.out.println("passcode: " + "<empty string>");
	}

}
