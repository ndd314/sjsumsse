package payonthego;

public class KeyPadScreenAdapter extends KeyPad {
	private int offsetX;
	private int offsetY;
	
	public KeyPadScreenAdapter(int offsetX, int offsetY) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}
	
	public String keyPressed(int x, int y) {
		if (x-offsetX < 0) return null;
		if (y-offsetY < 0) return null;
		
		return super.keyPressed(x-offsetX, y-offsetY);
	}
}
