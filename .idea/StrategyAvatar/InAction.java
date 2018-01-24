package strategy;

import java.util.HashMap;

public class InAction implements Strategy {

	private Avatar avi;
	private HashMap<String, Action> actions = new HashMap<String, Action>();

	@Override
	public void execute(String command) throws NoSuchException {

		command = command.toLowerCase();
		if (actions.containsKey(command)) {
			System.out.print("I am " + avi.getName() + " the " + avi.getClass().getSimpleName() + ".");
			actions.get(command).doIt();
		} else {
			throw new NoSuchException(command + " is not a valid command for a " + avi.getClass().getSimpleName());
		}
	}

	@Override
	public void setAvatar(Avatar avatar) {
		this.avi = avatar;
	}

	@Override
	public void addAction(String command, Action action) {
		actions.put(command.toLowerCase(), action);
	}
}
