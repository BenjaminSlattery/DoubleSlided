package boundary;

import entity.Square;
import javax.swing.JTextPane;

public class SquareBoundary {
	Square square;
	int x, y, width, length;
	JTextPane text;
	
	public SquareBoundary(Square square, JTextPane text) {
		this.square = square;
		this.text = text;
	}
}
