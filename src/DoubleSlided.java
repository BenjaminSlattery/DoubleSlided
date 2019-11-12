import java.awt.EventQueue;
import java.util.ArrayList;

import boundary.DoubleSlidedWindow;
import controller.TileKeyListener;
import entity.Board;
import entity.Model;
import entity.Tile;

public class DoubleSlided {

	public static void main(String[] args) {
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoubleSlidedWindow frame = new DoubleSlidedWindow(model);
					TileKeyListener listener = new TileKeyListener(model, frame);
					frame.addKeyListener(listener);
					frame.listen(listener);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
