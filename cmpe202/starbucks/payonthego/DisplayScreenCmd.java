package payonthego;
/**
 * 
 */

/**
 * @author dnguyen
 *
 */
public class DisplayScreenCmd implements Command {

	/* (non-Javadoc)
	 * @see Command#execute()
	 */
	
	private Screen screen;
		
	DisplayScreenCmd(Screen screen) {
		this.screen = screen;
	}
	
	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	
	public String execute() {
		// TODO Auto-generated method stub
		if (null!=screen) {
			return screen.display();
		} else {
			return null;
		}
	}

}
