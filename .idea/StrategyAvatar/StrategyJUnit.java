package strategy;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class StrategyJUnit {

	Grid board;
	Avatar p1, p2, p3;

	@Before
	public void setUp() throws Exception {

		Avatar p1 = new Player("B");
		Avatar p2 = new Player("S");

		Strategy aviStrategy = new InAction();

		p1.setStrategy(aviStrategy);
		p2.setStrategy(aviStrategy);

		Grid board = new Grid(10, 10);

	}

	@Test
	public void testExceptionClass() throws NoSuchException {
		try {
			p1.listen("eat");
		} catch (NoSuchException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	public void distanceTest() {
		Position testPosition = new Position(0, 0);
		Position testPosition1 = new Position(0, 0);
		board.add(p1, new Position(0, 1));
		board.add(p2, new Position(7, 2));
		board.calculateDistance(testPosition, testPosition1);
		int actual = board.getDistance();

		assertNull(actual);
	}

}
