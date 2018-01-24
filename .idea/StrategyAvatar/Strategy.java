package strategy;

public interface Strategy {

	public void execute(String command) throws NoSuchException;

	public void setAvatar(Avatar avatar);

	public void addAction(String command, Action action);

}
