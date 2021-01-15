import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Helps select the Person that can be dragged around in MousePersonPortion
 * @author Seth Miller
 *
 */
public class PersonMenu extends JPanel implements ActionListener{
//button to scroll forward in people
JButton nextP;
//button to scroll backward in people
JButton backP;

ArrayList<Person> people;
int currPerson = 0;

	/**
	 * Builds a Menu of People in city to scroll through
	 * @param city - city holding people to display as a list
	 */
	PersonMenu(City city){
		init(city);
	}
	
	/**
	 * Helper method to set the buttons and save the people in the city
	 * @param city - city holding people to display as a list
	 */
	private void init(City city) {
		nextP = new JButton("Next Person");
		nextP.addActionListener(this);
		
		backP = new JButton("Previous Person");
		backP.addActionListener(this);
		this.add(nextP);
		this.add(backP);
		
		people = city.getOccupants();
	}
	
	/**
	 * Paints all of the people, with the one with red lettering being the selected Person
	 */
	public void paintComponent (Graphics g) {
		for (int i = 0 ; i<people.size(); i++) {
			if (i==currPerson) {
				g.setColor(Color.red);
			}else {
				g.setColor(Color.black);
			}
			g.drawString((String) people.get(i).toString(), 0, 50*(2+i));
		}
		
	}
	
	/**
	 *  a getter to help Person Description and MousePersonPortion (In figuring out who to drag)
	 * @return - the index of selected person in Occupants
	 */
	public int getCurrPerson() {
		return(currPerson);
	}

	@Override
	/**
	 * Determines if the user wants to go forwards or backwards an Person, updating the current selection 
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == nextP) {
			if (currPerson < people.size()-1) {
				currPerson++;
			}
		}else if (e.getSource() == backP) {
			if(currPerson > 0)
				currPerson--;
		}
		repaint();
	}
	
}
