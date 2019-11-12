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
				break;
			}
		}
		window.refreshDisplay();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
