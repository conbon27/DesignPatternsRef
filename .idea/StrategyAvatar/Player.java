package strategy;

public class Player extends Avatar {

	// constructor
	public Player(String name) {
		super(name);

		// polymorphic use of ActionType to add new action
		actionType = new Jump();

		actionType = new Fly();

	}

}
