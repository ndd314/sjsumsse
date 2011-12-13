package payonthego;

public interface Screen {
	public void touch(int x, int y);
	public String display();
	public void topLeftCommand();
	public void topRightCommand();
	public String getScreenTitle();
}
