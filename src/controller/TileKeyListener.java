package controller;

import java.awt.event.KeyEvent;

import boundary.DoubleSlidedWindow;
import entity.Model;

public class TileKeyListener implements java.awt.event.KeyListener {
	Model model;
	DoubleSlidedWindow window;
	
	public TileKeyListener(Model model, DoubleSlidedWindow window) {
		this.model = model;
		this.window = window;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		int direction = arg0.getKeyCode();
		//System.out.printf("Key pressed %d!\n", direction);
		switch(direction) {
		case KeyEvent.VK_A: direction = KeyEvent.VK_LEFT; break;
		case KeyEvent.VK_W: direction = KeyEvent.VK_UP; break;
		case KeyEvent.VK_D: direction = KeyEvent.VK_RIGHT; break;
		case KeyEvent.VK_S: direction = KeyEvent.VK_DOWN; break;
		}
		if (model.isActive()) {
			switch(direction) {
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_UP:
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_DOWN:
				model.incrementCount();
				model.getBoard().moveSquares(direction);
				break;
			default:
				return;
			}
		}
		if (model.hasWon()) {
			System.out.print("You win!\n");	
			window.win();
		}
		if (model.hasLost()) {
			System.out.print("You lose!\n");	
			window.lose();
		}
		window.refreshDisplay();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
