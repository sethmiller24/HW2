import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Serves as a way to drag around the 
 * @author Seth Miller
 *
 */
public class MousePersonPortion extends JComponent implements MouseMotionListener, ActionListener{
int imageX, imageY;

static Graphics2D plane;

private JFrame frame;
private PersonMenu pm;

private Image img;


Toolkit toolkit = Toolkit.getDefaultToolkit();
Image background = toolkit.getImage("MapBackground.jpg").getScaledInstance(1500, 900, Image.SCALE_SMOOTH);


private City city;
private Person person;
private ArrayList <Person> people;
private Building[][] buildings;	
	
	MousePersonPortion(City city, JFrame frame, PersonMenu pm){
		this.frame = frame;
		this.pm = pm;
		this.people = city.getOccupants();
		this.person = people.get(pm.getCurrPerson());
		this.img = person.getImage();
		
		init(city);	
		
		addMouseMotionListener(this);
	}
	
	public void init(City city) {
		this.city = city;
		this.buildings = city.getBuildings();
		setAtBuildingLocation();
	}
	
	public void setAtBuildingLocation() {
		//search for current person's location
		for (int i = 0; i < buildings.length; i++)
			for (int j = 0; j < buildings[i].length; j++) {
				if (buildings[i][j].hasPerson(person)) {
					imageX = i*100;
					imageY = i*100;
					repaint();
				}
			}
	}
	
	public void updateMouse() {
		this.person = people.get(pm.getCurrPerson());
		this.img = person.getImage();
		setAtBuildingLocation();
		repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		updateMouse();
		imageX = e.getX();
		imageY = e.getY();
		repaint();
		
		//System.out.println(img.getSource() + " vs " + e.getSource());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void paint (Graphics g) {
		plane = (Graphics2D)g;
		plane.drawImage(background, 0, 0, this);
		paintBuildings(plane);
		plane.drawImage(img, imageX,imageY, this);
	}
	
	public void paintBuildings(Graphics2D g) {
		buildings = this.city.getBuildings();
		for (int i = 0; i< buildings.length; i++){
			for (int j = 0; j< buildings[i].length; j++) {
				g.drawImage( toolkit.getImage(buildings[i][j].getURL()),i*100,j*100, this);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		updateMouse();
	}
	
}
	