import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * CIty Component - Serves as the mediator between the City and the UI
 * @author Seth Miller
 * @version 4.0.0?
 */
public class CityComponent extends javax.swing.JComponent
	implements MouseMotionListener,MouseListener, ActionListener{
	JFrame frame;
	//Will hold a visual representation of occupants in the selected building
	JPanel buildingVisual;
	//Will hold broad options to enact, i.e. payEmployees, create a person or create a building
	JPanel menu;
	//Will hold a list of buttons representing each building to choose from to look into
	JPanel map;
	//When a person is selected, menu brought up to view attributes, and ability to move between buildings
	JPanel personMenu;
	int x, y;
	ArrayList <JButton>buttons = new ArrayList <JButton>();
	String output;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	final Image background = toolkit.createImage("MapBackground.jpg");
	
	
	
	
	/**
	 * Helper method to set up JFrame and mouse presets
	 * @param rows - the number of streets in the city, that turn into rows in the UI
	 * @param columns - the number of buildings per street, that turn into column in the UI
	 */
	private void init(int rows, int columns) {
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		
		map = new JPanel(new GridLayout(rows, columns));
		
		
		buildingVisual = new JPanel();
		personMenu = new JPanel();
		menu = new JPanel(new FlowLayout());
		//frame.setLayout(new FlowLayout());
		x = 0;
		y = 0;
		frame.setBounds(0, 0, rows*250, columns*250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(map, BorderLayout.NORTH);
		frame.add(menu, BorderLayout.EAST);
		frame.add(buildingVisual, BorderLayout.CENTER);
		frame.add(personMenu, BorderLayout.WEST);
		buildingVisual.add(new JButton(new ImageIcon(background)));
		
		addMouseMotionListener(this);
		
		repaint();
	}
	
	/**
	 * Represents the start up for the visuals
	 * @param rows - the number of streets in the city, that turn into rows in the UI
	 * @param columns - the number of buildings per street, that turn into column in the UI
	 */
	public void showScreen(Building[][]btns) {
		init(btns.length, btns[0].length);
		frame.setVisible(true);
		setButtons(btns);
	}
	
	/**
	 * Creates Buttons for each building
	 * @param btns - 2d array holding buildings to make buttons for
	 */
	public void setButtons(Building[][] btns) {
		int currBtn = 0;
		ImageIcon currBtnImg;
		for (int i = 0; i<btns.length; i++)
			for (int j = 0; j < btns[i].length; j++) {
				currBtnImg = makeImage(btns[i][j].getURL());
				buttons.add(new JButton(currBtnImg));
				buttons.get(currBtn).addActionListener(this);
				buttons.get(currBtn).setOpaque(true);
				map.add(buttons.get(currBtn));
				currBtn++;
			}
	}
	
	private ImageIcon makeImage(String URL) {
		Image img = toolkit.createImage(URL);
		img = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		return icon;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(background, 0,0,this);
		g.drawString(output,x,y);
		System.out.println("In repaint");
	}
	
	private void updateMouseLoc(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		e.getComponent().setLocation(e.getX(),e.getY());
		updateMouseLoc(e);
		repaint();
	}
	
	

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i<buttons.size(); i++) {
			if(e.getSource() == buttons.get(i).getLocation()) {
				output = "Space "+i;
				repaint();
				System.out.println(i+" button pressed");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
