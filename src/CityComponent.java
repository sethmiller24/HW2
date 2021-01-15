import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JComponent;

/**
 * CIty Component - Serves as the mediator between the City and the UI
 * @author Seth Miller
 * @version 5.0.0?
 */
public class CityComponent extends javax.swing.JComponent implements ActionListener{
	//The data to manipulate
	City city;
	
	Building [][] buildings;
	
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	//The map layout
	JFrame frame;
	
	//Center
	JPanel map;
	
	//East
	BuildingMenu buildingMenu;
	
	//West
	PersonMenu personM;
	
	
	//South
	PersonDescription personDes;
	
	
	ArrayList <MousePersonPortion> miceReaders = new ArrayList <MousePersonPortion>(); 
	
	
	/*
	 * Building the UI for the City
	 */
	CityComponent(City city){
		init(city);
	}
	
	/**
	 * Builds the Frame, it's components and saves the data of the city inputted
	 * @param city - the city displayed in the UI
	 */
	private void init(City city){
		this.city = city;
		this.buildings = city.getBuildings();
		frame = new JFrame("City Map");
		frame.setLayout(new GridLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,600);
		
		
		buildingMenu = new BuildingMenu(city);
		
		personM = new PersonMenu(city);
		
		personDes = new PersonDescription(personM, city.getOccupants());		
		
		frame.add(buildingMenu, BorderLayout.EAST);
		
		frame.add(personM, BorderLayout.WEST);
	
		frame.add(personDes, BorderLayout.SOUTH);

		frame.add(new MousePersonPortion(city, frame, personM), BorderLayout.CENTER);
		
		repaint();
		
		frame.setVisible(true);
	}
	
	
	/**
	 * Faulty/Abandoned method to paint the city...
	 * Expand on when repaint works
	 */
	public void paintComponent (Graphics g) {
		Graphics2D graphic2 = (Graphics2D)g;
		System.out.println("CityComponent's Repaint Works!");	
	}

	@Override
	/**
	 * An attempt to call repaint...
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.repaint();
	}
	
}
