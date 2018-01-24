package strategy;

public class Position {

	private int positionX;
	private int positionY;

	// method to set player position on 2d array board
	public Position(int pos1, int pos2) {
		setPositionX(pos1);
		setPositionY(pos2);
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

}
