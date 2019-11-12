package entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ModelTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testOneLiners() {
		Model model = new Model();
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		tiles.add(new Tile("1", "4", false));
		tiles.add(new Tile("2", "3", false));
		tiles.add(new Tile("3", "2", false));
		tiles.add(new Tile("1", "4", true));
		tiles.add(null);
		tiles.add(new Tile("4", "1", false));
		tiles.add(new Tile("2", "3", true));
		tiles.add(new Tile("3", "2", true));
		tiles.add(new Tile("4", "1", true));
		model.setSolution(new Board(tiles));
		
		assertEquals(model.hasWon(), false);
		model.board = model.solution;
		assertEquals(model.hasWon(), true);
		
		ArrayList<Tile> tiles2 = new ArrayList<Tile>();
		tiles2.add(new Tile("1", "4", false));
		tiles2.add(new Tile("2", "3", false));
		tiles2.add(new Tile("1", "2", false));
		tiles2.add(new Tile("1", "4", true));
		tiles2.add(null);
		tiles2.add(new Tile("4", "1", false));
		tiles2.add(new Tile("2", "3", true));
		tiles2.add(new Tile("3", "1", true));
		tiles2.add(new Tile("4", "1", true));
		
		assertEquals(model.hasLost(), false);
		model.board = new Board(tiles2);
		assertEquals(model.hasLost(), true);
		
		assertEquals(model.board, model.getBoard());
		
		assertEquals(model.count, model.getCount());
		model.incrementCount();
		assertEquals(model.count, model.getCount());

		assertEquals(model.active, model.isActive());
		assertEquals(model.active, true);
		model.end();
		assertEquals(model.active, model.isActive());
		assertEquals(model.active, false);
	}

	@Test
	public void testReset() {
		Model model = new Model();
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		tiles.add(new Tile("1", "4", false));
		tiles.add(new Tile("2", "3", false));
		tiles.add(new Tile("3", "2", false));
		tiles.add(new Tile("1", "4", true));
		tiles.add(null);
		tiles.add(new Tile("4", "1", false));
		tiles.add(new Tile("2", "3", true));
		tiles.add(new Tile("3", "2", true));
		tiles.add(new Tile("4", "1", true));
		model.setSolution(new Board(tiles));

		ArrayList<Tile> tiles2 = new ArrayList<Tile>();
		tiles2.add(new Tile("1", "4", false));
		tiles2.add(new Tile("3", "2", true));
		tiles2.add(null);
		tiles2.add(new Tile("3", "2", true));
		tiles2.add(new Tile("2", "3", true));
		tiles2.add(new Tile("4", "1", false));
		tiles2.add(new Tile("1", "4", false));
		tiles2.add(new Tile("2", "3", false));
		tiles2.add(new Tile("4", "1", true));
		assertEquals(model.board.equals(new Board(tiles2)), true);
		model.reset();
		assertEquals(model.board.equals(new Board(tiles2)), true);
		model.board = model.solution;
		assertEquals(model.board.equals(new Board(tiles2)), false);
		model.reset();
		assertEquals(model.board.equals(new Board(tiles2)), true);
		assertEquals(model.count, 0);
		model.incrementCount();
		assertEquals(model.count, 1);
		model.reset();
		assertEquals(model.count, 0);
		assertEquals(model.active, true);
		model.active = false;
		assertEquals(model.active, false);
		model.reset();
		assertEquals(model.active, true);
	}


	@Test
	public void testBoardEquals() {
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		tiles.add(new Tile("1", "4", false));
		tiles.add(new Tile("2", "3", false));
		tiles.add(new Tile("3", "2", false));
		tiles.add(new Tile("1", "4", true));
		tiles.add(null);
		tiles.add(new Tile("4", "1", false));
		tiles.add(new Tile("2", "3", true));
		tiles.add(new Tile("3", "2", true));
		tiles.add(new Tile("4", "1", true));

		ArrayList<Tile> tiles2 = new ArrayList<Tile>();
		tiles2.add(new Tile("1", "4", false));
		tiles2.add(new Tile("2", "3", false));
		tiles2.add(new Tile("3", "2", false));
		tiles2.add(new Tile("1", "4", true));
		tiles2.add(null);
		tiles2.add(new Tile("4", "1", false));
		tiles2.add(new Tile("2", "3", true));
		tiles2.add(new Tile("3", "2", true));
		tiles2.add(new Tile("4", "1", true));
		assertEquals(new Board(tiles).equals(new Board(tiles2)), true);
		

		ArrayList<Tile> tiles3 = new ArrayList<Tile>();
		tiles2.add(new Tile("1", "4", false));


		ArrayList<Tile> tiles4 = new ArrayList<Tile>();
		tiles2.add(new Tile("1", "4", false));
		tiles2.add(new Tile("7", "3", false));
		tiles2.add(new Tile("3", "2", false));
		tiles2.add(new Tile("1", "4", true));
		tiles2.add(null);
		tiles2.add(new Tile("4", "1", false));
		tiles2.add(new Tile("2", "3", true));
		tiles2.add(new Tile("3", "2", true));
		tiles2.add(new Tile("4", "1", true));
		assertEquals(new Board(tiles).equals(new Board(tiles3)), false);
		assertEquals(new Board(tiles2).equals(new Board(tiles4)), false);
	}
}
