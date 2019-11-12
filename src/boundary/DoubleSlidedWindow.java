package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Model;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class DoubleSlidedWindow extends JFrame {

	private JPanel contentPane;
	Model model;
	BoardBoundary boardBoundary;

	/**
	 * Create the frame.
	 */
	public DoubleSlidedWindow(Model model) {
		this.model = model;
		boardBoundary = new BoardBoundary(model.getBoard());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 230));
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JTextPane textPane = new JTextPane();
		JLabel textPaneLabel  = new JLabel();
		textPaneLabel.setText("Count:");
		textPane.setText("0");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(textPaneLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(40))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
		
		JPanel tiles[][] = new JPanel[3][3];
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				tiles[x][y] = new JPanel();
				tiles[x][y].setPreferredSize(new Dimension(10, 10));
				tiles[x][y].setMaximumSize(new Dimension(10, 10));
				
				if (x == 0) tiles[x][y].setAlignmentX(LEFT_ALIGNMENT);
				else if (x == 1) tiles[x][y].setAlignmentX(CENTER_ALIGNMENT);
				else if (x == 2) tiles[x][y].setAlignmentX(RIGHT_ALIGNMENT);
				
				if (y == 0) tiles[x][y].setAlignmentY(TOP_ALIGNMENT);
				else if (y == 1) tiles[x][y].setAlignmentY(CENTER_ALIGNMENT);
				else if (y == 2) tiles[x][y].setAlignmentY(BOTTOM_ALIGNMENT);
				
				//tiles[x][y].setBounds(panel.getWidth()*x*3/8, panel.getHeight()*y*3/8, panel.getWidth()/8, panel.getHeight()/8);
				tiles[x][y].setBackground(new Color(0, 100+50*y, 50*x));
				rows[x].addComponent(tiles[x][y]);
				columns[y].addComponent(tiles[x][y]);
			}
		}
		horizontalGroup.addGroup(rows[0]).addGroup(rows[1]).addGroup(rows[2]);
		verticalGroup.addGroup(columns[0]).addGroup(columns[1]).addGroup(columns[2]);
		panelLayout.setHorizontalGroup(horizontalGroup);
		panelLayout.setVerticalGroup(verticalGroup);
	}
}
