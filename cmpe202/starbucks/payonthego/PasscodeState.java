package payonthego;

public interface PasscodeState {
	public PasscodeState backspace();
	public PasscodeState number(String input);
	public String getPasscode();
	public int getState();
}
