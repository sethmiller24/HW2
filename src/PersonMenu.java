import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PersonMenu extends JPanel implements ActionListener{
JButton nextP;
JButton backP;

ArrayList<Person> people;
int currPerson = 0;

	PersonMenu(City city){
		nextP = new JButton("Next Person");
		nextP.addActionListener(this);
		
		backP = new JButton("Previous Person");
		backP.addActionListener(this);
		this.add(nextP);
		this.add(backP);
		
		people = city.getOccupants();
	}
	
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
	
	public int getCurrPerson() {
		return currPerson;
	}

	@Override
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
