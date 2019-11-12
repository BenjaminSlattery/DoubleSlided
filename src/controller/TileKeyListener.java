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
