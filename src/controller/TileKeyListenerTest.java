package controller;

import static org.junit.Assert.*;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import boundary.DoubleSlidedWindow;
import entity.Board;
import entity.Model;
import entity.Square;
import entity.Tile;

public class TileKeyListenerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testKeyPressed() {
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
		DoubleSlidedWindow frame = new DoubleSlidedWindow(model);
		TileKeyListener listener = new TileKeyListener(model, frame);
		frame.addKeyListener(listener);
		frame.listen(listener);
		frame.setVisible(true);

		@SuppressWarnings("deprecation")
		KeyEvent up = new KeyEvent(frame, 0, 0, 0, Square.UP);
		@SuppressWarnings("deprecation")
		KeyEvent down = new KeyEvent(frame, 0, 0, 0, Square.DOWN);
		@SuppressWarnings("deprecation")
		KeyEvent left = new KeyEvent(frame, 0, 0, 0, Square.LEFT);
		@SuppressWarnings("deprecation")
		KeyEvent right = new KeyEvent(frame, 0, 0, 0, Square.RIGHT);
		listener.keyPressed(up);
		assertEquals(model.hasLost(), true);
		Board lastBoard = model.getBoard();
		listener.keyPressed(up);
		listener.keyPressed(left);
		assertEquals(model.getBoard(), lastBoard);
		listener.keyPressed(new KeyEvent(frame, 0, 0, 0, KeyEvent.VK_B));
		assertEquals(model.getBoard(), lastBoard);
		
					
		model.reset();
					
		listener.keyPressed(right);
		listener.keyPressed(up);
		listener.keyPressed(right);
		listener.keyPressed(up);
		listener.keyPressed(left);
		listener.keyPressed(down);
		assertEquals(model.hasWon(), true);
	}

}
