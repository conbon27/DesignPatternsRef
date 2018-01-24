package strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Grid {
	// primary responsibility is to create a Player space & add player to same

	private int Rows;
	private int Columns;
	Map<Avatar, Position> avatars;
	private int Distance;

	// create 2 dimensional array of type Player
	Avatar[][] grid;

	// class constructor
	// use passed value to set size of game space
	public Grid(int rows, int columns) {
		avatars = new HashMap<Avatar, Position>();
		Rows = rows;
		Columns = columns;
		grid = new Player[rows][columns];
		for (int j = 0; j < rows; j++) {
			for (int k = 0; k < columns; k++) {
			}
		}
	}

	// print method to check grid status
	public void printGrid() {
		for (int i = 0; i < grid.length; i++) {
			System.out.println(grid[i][0] + " " + grid[i][1] + " " + grid[i][2] + " " + grid[i][3] + grid[i][4] + " "
					+ grid[i][5] + " " + grid[i][6] + " " + grid[i][7]);
		}
	}

	// method to add player to grid board in game
	public void add(Avatar p2, Position pos) {
		int x = pos.getPositionX();
		int y = pos.getPositionY();
		grid[x][y] = p2;
		avatars.put(p2, pos);
		System.out.println(p2.getName() + " starts at " + pos.getPositionX() + pos.getPositionY());
	}

	// method to generate random 2d array coordinates to be moved to
	public Position getRandXY() {
		Random r = new Random();
		int column = r.nextInt(8);
		int row = r.nextInt(8);
		Position pos1 = new Position(column, row);
		return pos1;
	}

	// getters & setters for distance variable
	public int getDistance() {
		return Distance;
	}

	public void setDistance(int distance) {
		Distance = distance;
	}

	// distance method based on previous - current positions in 2d array
	public void calculateDistance(Position previous, Position current) {
		int currentX = current.getPositionX();
		int currentY = current.getPositionY();
		int previousX = previous.getPositionX();
		int previousY = previous.getPositionY();
		int deltaX = (previousX - currentX);
		int deltaY = (previousY - currentY);

		// code for Pytag theory to get "crow's flight" distance
		this.setDistance((int) Math.round(Math.sqrt((deltaX * deltaX) + (deltaY * deltaY))));
	}

}