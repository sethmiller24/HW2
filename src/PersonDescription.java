import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * JPanel that primarily is used to read the stats on the current selected person in PersonMenu
 * (Would have merged this code into CityComponent if I knew why CityComponent's repaint didn't call paintComponent(Graphics g))
 * @author Seth Miller
 *
 */
public class PersonDescription  extends JPanel implements MouseMotionListener{
	PersonMenu pm;
	ArrayList <Person> people;
	
	/*
	 * Builds this JPanel around the PersonMenu and the ArrayList of Person in it
	 */
	PersonDescription(PersonMenu pm, ArrayList <Person> people){
		this.pm = pm;
		this.people = people;
	}
	
	/**
	 * draws the toString of the selected person in pm
	 */
	public void paintComponent (Graphics g) {
		//	0,500 approximates where I think BorderLayout.South should be...
		g.drawString("Current Person Selected: ", 0, 475);	
		g.drawString(people.get(pm.getCurrPerson()).toString(),0,500);
		}


	@Override
	/**
	 * Attempt to update paintComponent as frequently as I found possible
	 */
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
		
	}

