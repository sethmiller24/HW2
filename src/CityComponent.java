import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * CIty Component - Serves as the midiator between the City and the UI
 * @author Seth Miller
 * @version 4.0.0?
 */
public class CityComponent extends javax.swing.JComponent
	implements MouseMotionListener, ActionListener{
	JFrame frame;
	int x, y;
	ArrayList <JButton>buttons = new ArrayList <JButton>();
	String output;
	
	/**
	 * Helper method to set up JFrame and mouse presets
	 * @param rows - the number of streets in the city, that turn into rows in the UI
	 * @param columns - the number of buildings per street, that turn into column in the UI
	 */
	private void init(int rows, int columns) {
		frame = new JFrame();
		frame.setLayout(new GridLayout(rows, columns));
		//frame.setLayout(new FlowLayout());
		x = 0;
		y = 0;
		frame.setBounds(100, 100, rows*150, columns*150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addMouseMotionListener(this);
	}
	
	/**
	 * Represents the start up for the visuals
	 * @param rows - the number of streets in the city, that turn into rows in the UI
	 * @param columns - the number of buildings per street, that turn into column in the UI
	 */
	public void showScreen(int rows, int columns) {
		init(rows, columns);
		frame.setVisible(true);
	}
	
	/**
	 * Creates Buttons for each building
	 * @param btns - 2d array holding buildings to make buttons for
	 */
	public void setButtons(Building[][] btns) {
		int currBtn = 0;
		for (int i = 0; i<btns.length; i++)
			for (int j = 0; j < btns[i].length; j++) {
				buttons.add(new JButton(btns[i][j].name));
				buttons.get(currBtn).addActionListener(this);
				frame.add(buttons.get(currBtn));
				currBtn++;
			}
	}
	
	public void paintComponent(Graphics g) {
		g.drawString(output,x,y);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i<buttons.size(); i++) {
			if(e.getSource() == buttons.get(i)) {
				output = "Space "+i;
				repaint();
				System.out.println(i+" button pressed");
			}
		}
	}

}
