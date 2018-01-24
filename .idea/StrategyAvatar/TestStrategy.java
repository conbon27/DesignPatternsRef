package strategy;

public class TestStrategy {

	public static void main(String[] args) {

		// creates instances of the Avatar extended class player
		Avatar p1 = new Player("Bee");
		Avatar p2 = new Player("Spider");

		// creates new strategies & adds actions
		Strategy jumpStrategy = new InAction();
		jumpStrategy.addAction("jump", new Jump());
		Strategy flyStrategy = new InAction();
		flyStrategy.addAction("fly", new Fly());

		// adds strategies to players
		p1.setStrategy(jumpStrategy);
		p2.setStrategy(flyStrategy);

		// test to ensure that only assigned strategies work
		try {
			p1.listen("eat");
		} catch (NoSuchException e) {

			System.out.println(e.getMessage());
		}
		// creates & prints out grid as play board and prints to show
		Grid board = new Grid(8, 8);
		board.printGrid();

		// initial positions added & shown
		board.add(p1, new Position(0, 1));
		board.add(p2, new Position(7, 2));

		// for 20 iterations, move players to random locations on grid
		// calls name and the action the players are using to move as per
		// distance method
		for (int z = 0; z < 20; z++) {
			try {
				p1.move(board.getRandXY());
				if (board.getDistance() < 1) {
					// allows for dynamic change of action at CLR
					p1.setAction(new Jump());
					System.out.println(p1.getName() + " " + p1.actionAttempt());
				} else {
					p1.setAction(new Fly());
					System.out.println(p1.getName() + " " + p1.actionAttempt());
				}

			} catch (NoSuchException e) {
				e.printStackTrace();
			}
			try {
				p2.move(board.getRandXY());
				if (board.getDistance() < 1) {
					// allows for dynamic change of action
					p2.setAction(new Jump());
					System.out.println(p2.getName() + " " + p2.actionAttempt());
				} else {
					p2.setAction(new Fly());
					System.out.println(p2.getName() + " " + p2.actionAttempt());
				}
			} catch (NoSuchException e) {
				e.printStackTrace();
			}
		}
	}
}