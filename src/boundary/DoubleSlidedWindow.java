package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entity.Model;
import entity.Tile;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class DoubleSlidedWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JLabel countPane;
	
	Model model;
	BoardBoundary boardBoundary;
	
	JPanel tiles[][];
	JLabel tileNumbers[][];
	

	/**
	 * Create the frame.
	 */
	public DoubleSlidedWindow(Model model) {
		this.model = model;
		boardBoundary = new BoardBoundary(model.getBoard());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(230, 230, 230));
		
		btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.reset();
				refreshDisplay();
			}
		});
		
		countPane = new JLabel();
		JLabel textPaneLabel  = new JLabel();
		textPaneLabel.setText("Count:");
		countPane.setText("0");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(textPaneLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(40))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(countPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(69))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(102)
							.addComponent(btnNewButton)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textPaneLabel)
								.addComponent(countPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		
		contentPane.setLayout(gl_contentPane);
		
		GroupLayout panelLayout = new GroupLayout(panel);
		panel.setLayout(panelLayout);
		ParallelGroup horizontalGroup = panelLayout.createParallelGroup(Alignment.LEADING);
		ParallelGroup verticalGroup = panelLayout.createParallelGroup(Alignment.LEADING);
		SequentialGroup rows[] = new SequentialGroup[3];
		SequentialGroup columns[] = new SequentialGroup[3];
		for (int x = 0; x < 3; x++) {
			rows[x] = panelLayout.createSequentialGroup();
			columns[x] = panelLayout.createSequentialGroup();
		}
		
		System.out.printf("Panel size: %d %d\n", panel.getWidth(), panel.getHeight());
		System.out.printf("Panel size: %d %d\n", panelLayout.preferredLayoutSize(panel).width, panelLayout.preferredLayoutSize(panel).height);
		
		//panel.
		
		tiles = new JPanel[3][3];
		tileNumbers = new JLabel[3][3];
		int i = 0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				tiles[x][y] = new JPanel();
				tileNumbers[x][y] = new JLabel();
				tileNumbers[x][y].setFont(new Font("TimesRoman", Font.BOLD, 150));
				tileNumbers[x][y].setText(Integer.toString(i++));
				int newx = panel.getWidth()*10;
				int newy = panel.getHeight()/4;
				tiles[x][y].setPreferredSize(new Dimension(newx, newy));
				tiles[x][y].setMaximumSize(new Dimension(newx, newy));
				
				//tiles[x][y].setBounds(panel.getWidth()*x*3/8, panel.getHeight()*y*3/8, panel.getWidth()/8, panel.getHeight()/8);
				tiles[x][y].setBackground(new Color(0, 100+50*y, 50*x));
				tiles[x][y].add(tileNumbers[x][y]);
				rows[y].addComponent(tiles[x][y], GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE);
				rows[y].addGap(25);
				columns[x].addComponent(tiles[x][y], GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE);
				columns[x].addGap(25);
			}
		}
		horizontalGroup.addGroup(rows[0]).addGroup(rows[1]).addGroup(rows[2]);
		verticalGroup.addGroup(columns[0]).addGroup(columns[1]).addGroup(columns[2]);
		panelLayout.setHorizontalGroup(horizontalGroup);
		panelLayout.setVerticalGroup(verticalGroup);
		refreshDisplay();
	}
	
	public void refreshDisplay() {
		countPane.setText(Integer.toString(model.getCount()));
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				Tile tile = model.getBoard().getSquare(x, y).getTile();
				Color colorBack = new Color(255, 255, 0);
				Color colorFore = new Color(255, 255, 0);
				if (tile != null) {
					if (tile.getIsFlipped()) {
						colorBack = new Color(0, 0, 0);
						colorFore = new Color(255, 255, 255);
					} else {
						colorBack = new Color(127, 127, 127);
						colorFore = new Color(0, 0, 0);
					}
				}
				tiles[x][y].setBackground(colorBack);
				tileNumbers[x][y].setText(tile!=null?tile.getCurrentLabel():"4");
				tileNumbers[x][y].setForeground(colorFore);
			}
		}
	}
	
	public void listen(KeyListener listener) {
		contentPane.addKeyListener(listener);
		panel.addKeyListener(listener);
		btnNewButton.addKeyListener(listener);
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				tiles[x][y].addKeyListener(listener);
			}
		}
	}
}
