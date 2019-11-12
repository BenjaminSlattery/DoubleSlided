package entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testGetSquare() {
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
		Board board1 = new Board(tiles);
		assertEquals(board1.getSquare(1, 1).tile, null);
		assertEquals(board1.getSquare(0, 0).tile.equals(new Tile("1", "4", false)), true);
		assertEquals(board1.getSquare(1, 2).tile.equals(new Tile("3", "2", true)), true);
	}

	@Test
	public void testMoveSquares() {
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
		tiles2.add(null);
		tiles2.add(new Tile("1", "4", false));
		tiles2.add(new Tile("4", "1", false));
		tiles2.add(new Tile("2", "3", true));
		tiles2.add(new Tile("3", "2", true));
		tiles2.add(new Tile("4", "1", true));
		Board board1 = new Board(tiles);
		board1.moveSquares(Square.RIGHT);
		assertEquals(new Board(tiles2).equals(board1), true);
		board1.moveSquares(Square.RIGHT);
		assertEquals(new Board(tiles2).equals(board1), true);
		board1.moveSquares(Square.LEFT);
		assertEquals(new Board(tiles).equals(board1), true);
	}

	@Test
	public void testHasLost() {
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
		assertEquals(new Board(tiles).hasLost(), false);

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
		assertEquals(new Board(tiles2).hasLost(), true);
	}

}
