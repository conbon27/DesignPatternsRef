package strategy;

public abstract class Avatar {

	protected String name;
	protected Strategy strategy;
	protected Grid grid;
	protected Avatar avi;
	protected Action actionType;

	public Avatar(String name) {
		this.name = name;
	}

	public String actionAttempt() {
		return actionType.doIt();
	}

	// allows for dynamic change of action at runtime
	public void setAction(Action newActionType) {
		actionType = newActionType;
	}

	// Each actor has an action that can be called
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
		strategy.setAvatar(this);
	}

	// reaction to commands it receives here
	public void listen(String command) throws NoSuchException {
		this.strategy.execute(command);
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public String getName() {
		return name;
	}
	// move method which throws exception

	public void move(Position pos) throws NoSuchException {

		int x = pos.getPositionX();
		int y = pos.getPositionY();

		System.out.println(name + " is at " + pos.getPositionX() + pos.getPositionY());

	}
}