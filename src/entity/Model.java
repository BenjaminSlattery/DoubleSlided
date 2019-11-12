package entity;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class Model {
	Board board;
	Board solution;
	int count;public int getCount() {return count;}
	boolean active;public boolean isActive() {return active;}
	
	public void incrementCount() {
		count++;
	}
	
	public Model() {
		reset();
	}
	public Board getBoard() {return board;}
	public void setSolution(Board solution) {
		this.solution = solution;
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

	public void reset() {
		count = 0;
		active = true;
		
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		tiles.add(new Tile("1", "4", false));
		tiles.add(new Tile("3", "2", true));
		tiles.add(null);
		tiles.add(new Tile("3", "2", true));
		tiles.add(new Tile("2", "3", true));
		tiles.add(new Tile("4", "1", false));
		tiles.add(new Tile("1", "4", false));
		tiles.add(new Tile("2", "3", false));
		tiles.add(new Tile("4", "1", true));
		board = new Board(tiles);
	}
}
