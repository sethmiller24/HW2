import java.awt.BorderLayout;
import java.awt.Color;
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
 * @version 5.0.0?
 */
public class CityComponent extends javax.swing.JComponent{
	//The data to manipulate
	City city;
	
	Building [][] buildings;
	
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Image background = toolkit.getImage("MapBackground.jpg").getScaledInstance(1500, 900, Image.SCALE_SMOOTH);
	
	//The map layout
	JFrame frame;
	
	//Center
	JPanel map;
	//East
	JPanel buildingMenu;
	//West
	PersonMenu personM;
	//South
	JPanel personDes;
	
	ArrayList <MousePersonPortion> miceReaders = new ArrayList <MousePersonPortion>(); 
	
	
	
	CityComponent(City city){
		init(city);
	}
	
	private void init(City city){
		this.city = city;
		frame = new JFrame("City Map");
		frame.setLayout(new GridLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setVisible(true);
		
		buildingMenu = new JPanel();
		personM = new PersonMenu(city);
		personDes = new JPanel();
		
		//frame.add(buildingMenu, BorderLayout.EAST);
		frame.add(personM, BorderLayout.WEST);
		frame.add(personDes, BorderLayout.SOUTH);
		
		updateMousePortion(city);
	}
	
	public void paint (Graphics g) {
		Graphics2D graphic2 = (Graphics2D)g;
		graphic2.drawImage(background, 0, 0, map);
		paintBuildings(graphic2);
	}
	
	public void paintBuildings(Graphics2D g) {
		buildings = this.city.getBuildings();
		for (int i = 0; i< buildings.length; i++){
			for (int j = 0; j< buildings[i].length; j++) {
				g.drawImage( toolkit.getImage(buildings[i][j].getURL()),i*100,j*100, map);
			}
		}
	}
	
	private void updateMousePortion(City city) {
			for (int i = 0; i<city.getOccupants().size(); i++) {
				miceReaders.add(new MousePersonPortion(city, map, (Person) city.getOccupants().get(i)));
				frame.add(miceReaders.get(i));
			}
	}
	
	
}
