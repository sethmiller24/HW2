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
import javax.swing.JPanel;

public class MousePersonPortion extends JComponent implements MouseMotionListener, ActionListener{
int imageX, imageY;

static Graphics2D plane;

static JPanel map;

private Image img;

boolean draggingImg = false;

Toolkit toolkit = Toolkit.getDefaultToolkit();

private City city;
private Person person;
private Building[][] buildings;	
	
	MousePersonPortion(City city, JPanel map,Person _person){
		this.person = person;
		this.img = _person.getImage();
		this.map = map;
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
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//if (draggingImg) {
			imageX = e.getX();
			imageY = e.getY();
		//}
		repaint();
		draggingImg = false;
		//System.out.println(img.getSource() + " vs " + e.getSource());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void paint (Graphics g) {
		plane = (Graphics2D)g;
		g.drawImage(img, imageX,imageY, map);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == img) {
			draggingImg = true;
		}else {
			draggingImg =false;
		}
	}
	
}
	