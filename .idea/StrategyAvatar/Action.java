package strategy;

public interface Action {

	public String doIt();
}

// classes which implement action variables & return action
class Jump implements Action {

	@Override
	public String doIt() {
		return "jumping";
	}
}

class Fly implements Action {

	@Override
	public String doIt() {
		return "flying";
	}
}
