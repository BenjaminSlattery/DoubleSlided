package entity;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class Square {
	Tile tile;
	int x, y;
	HashMap<Integer, Square> next;
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;
	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	int movePlan;
	
	private void init(int x, int y) {
		movePlan = 0;
		this.x = x;
		this.y = y;
		next = new HashMap<Integer, Square>();
		next.put(UP, null);
		next.put(DOWN, null);
		next.put(LEFT, null);
		next.put(RIGHT, null);
	}
	public Square(int x, int y) {
		init(x, y);
		tile = null;
	}
	public void setTile(String top, String bottom, boolean isFlipped) {
		tile = new Tile(top, bottom, isFlipped);
	}
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	/*public Square(int x, int y, String top, String bottom, boolean isFlipped) {
		init(x, y);
		setTile(top, bottom, isFlipped);
	}*/
	public boolean equals(Square other) {
		return (tile != null && tile.equals(other.tile)) || (tile == null && other.tile == null);
	}
	public int reverse(int direction) {
		switch(direction) {
		case LEFT: return RIGHT;
		case UP: return DOWN;
		case RIGHT: return LEFT;
		case DOWN: return UP;
		}
		return 0;
	}
	public void connect(Square other, int direction) {
		next.put(direction, other);
		if (other != null) other.next.put(reverse(direction), this); //+2, %4 rotates the direction 180 degrees
	}
	public Tile getTile () {
		return tile;
	}
	public void move(int direction) {
		System.out.printf("Square (%d, %d) moving\n", x, y); 
		tile.flip();
		next.get(direction).setTile(tile);
		setTile(null);
	}
	public void planMove(int direction) {
		if (next.get(direction) != null && next.get(direction).tile == null) movePlan = direction;
	}
	public void executeMove() {
		if (movePlan != 0) {
			move(movePlan);
			movePlan = 0;
		}
	}
}
