package entity;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class Model {
	Board board;
	Board solution;
	int count;public int getCount() {return count;}
	boolean active;public boolean isActive() {return active;}
	public void end() {active = false;}
	
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
	
	public boolean hasWon() {
		return board.equals(solution);
	}
	
	public boolean hasLost() {
		return board.hasLost();
	}
}
