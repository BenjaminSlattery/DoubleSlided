package boundary;

import java.util.ArrayList;
import java.util.Iterator;

import entity.Board;
import entity.Square;

public class BoardBoundary {
	Board board;
	ArrayList<SquareBoundary> squares;
	
	public BoardBoundary(Board board) {
		this.board = board;
		squares = new ArrayList<SquareBoundary>();
		Iterator<Square> entitySquares = board.getSquares().iterator();
		while (entitySquares.hasNext()) {
			squares.add(new SquareBoundary(entitySquares.next(), null));
			//entitySquares.remove();
		}
	}
}
