package entity;

import java.util.ArrayList;
import java.util.Iterator;

public class Board {
	ArrayList<Square> squares;
	
	private void init() {
		squares = new ArrayList<Square>();
		squares.add(new Square(0, 0));
		squares.add(new Square(1, 0));
		squares.add(new Square(2, 0));
		squares.add(new Square(0, 1));
		squares.add(new Square(1, 1));
		squares.add(new Square(2, 1));
		squares.add(new Square(0, 2));
		squares.add(new Square(1, 2));
		squares.add(new Square(2, 2));
		squares.get(0).connect(squares.get(1), Square.RIGHT);
		squares.get(1).connect(squares.get(2), Square.RIGHT);
		squares.get(3).connect(squares.get(4), Square.RIGHT);
		squares.get(4).connect(squares.get(5), Square.RIGHT);
		squares.get(6).connect(squares.get(7), Square.RIGHT);
		squares.get(7).connect(squares.get(8), Square.RIGHT);
		squares.get(0).connect(squares.get(3), Square.DOWN);
		squares.get(1).connect(squares.get(4), Square.DOWN);
		squares.get(2).connect(squares.get(5), Square.DOWN);
		squares.get(3).connect(squares.get(6), Square.DOWN);
		squares.get(4).connect(squares.get(7), Square.DOWN);
		squares.get(5).connect(squares.get(8), Square.DOWN);
	}
	public Board() {
		init();
	}
	public Board(ArrayList<Tile> tiles) {
		init();
		Iterator<Square> mySquares = squares.iterator();
		Iterator<Tile> otherTiles = tiles.iterator();
		while(mySquares.hasNext() && otherTiles.hasNext()) {
			Square mySquare = mySquares.next();
			Tile otherTile = otherTiles.next();
			if (mySquare.getTile() != null) mySquare.getTile().print();
			else System.out.print("\nFalse tile mine");
			System.out.print("\n");
			if (mySquare.getTile() != null) otherTile.print();
			else System.out.print("False tile other");
			System.out.print("\n\n");
			if (otherTile == null) mySquare.setTile(null);
			else mySquare.setTile(otherTile.labels[0], otherTile.labels[1], otherTile.isFlipped);
			//mySquares.remove();
			//otherTiles.remove();
		}
	}
	public boolean equals(Board other) {
		boolean result = true;
		Iterator<Square> mySquares = squares.iterator();
		Iterator<Square> otherSquares = other.squares.iterator();
		while(mySquares.hasNext() && otherSquares.hasNext()) {
			Square myCurrentSquare = mySquares.next();
			Square otherCurrentSquare = otherSquares.next();
			boolean answer = myCurrentSquare.equals(otherCurrentSquare);
			result = result && answer;
			//mySquares.remove();
			//otherSquares.remove();
		}
		return result && !mySquares.hasNext() && !otherSquares.hasNext();
	}
	public ArrayList<Square> getSquares() {
		return squares;
	}
	public Square getSquare(int x, int y) {
		Square result = null;
		Iterator<Square> mySquares = squares.iterator();
		while(mySquares.hasNext()) {
			Square nextSquare = mySquares.next();
			if (nextSquare.x == x && nextSquare.y == y) {
				result = nextSquare;
				return result;
			}
		}
		return result;
	}
	public void moveSquares(int direction) {
		Iterator<Square> mySquares = squares.iterator();
		while(mySquares.hasNext()) {
			mySquares.next().planMove(direction);
		}
		mySquares = squares.iterator();
		while(mySquares.hasNext()) {
			mySquares.next().executeMove();;
		}
	}
}
