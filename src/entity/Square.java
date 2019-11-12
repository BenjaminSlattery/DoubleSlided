package entity;

public class Square {
	Tile tile;
	int x, y;
	Square next[];
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	private void init(int x, int y) {
		this.x = x;
		this.y = y;
		next = new Square[4];
		next[UP] = null;
		next[DOWN] = null;
		next[LEFT] = null;
		next[RIGHT] = null;
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
	public Square(int x, int y, String top, String bottom, boolean isFlipped) {
		init(x, y);
		setTile(top, bottom, isFlipped);
	}
	public boolean equals(Square other) {
		return (tile != null && tile.equals(other.tile)) || (tile == null && other.tile == null);
	}
	public void connect(Square other, int direction) {
		next[direction] = other;
		if (other != null) other.next[(direction+2)%4] = this; //+2, %4 rotates the direction 180 degrees
	}
	public Tile getTile () {
		return tile;
	}
}
