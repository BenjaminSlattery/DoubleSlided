package entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SquareTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConnect() {
		Square s1 = new Square(0, 0);
		Square s2 = new Square(1, 1);
		s1.connect(s2, Square.UP);
		assertEquals(s1, s2.next.get(Square.DOWN));
		assertEquals(s2, s1.next.get(Square.UP));
	}
	
	@Test
	public void testMove() {
		Square s1 = new Square(0, 0);
		Square s2 = new Square(1, 1);
		s1.connect(s2, Square.UP);
		Tile t1 = new Tile("1", "1", false);
		Tile t2 = null;
		s1.setTile(t1);
		s2.setTile(t2);
		assertEquals(s1.getTile().equals(t1), true);
		assertEquals(s2.getTile(), null);
		s1.move(Square.UP);
		assertEquals(s1.getTile(), null);
		assertEquals(s2.getTile().equals(t1), true);
	}
}
