import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CityComponentInterfaceThingy extends JComponent{
	JFrame main;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	ArrayList<Person> people;
	
	CityComponentInterfaceThingy(City city){
		main = new JFrame();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(500,500);
		main.setLayout(new FlowLayout());
		main.setVisible(true);
		
		people = city.getOccupants();
		
		city.populateCity(new Person());
		
		main.add(new ImageIcon());
		
		MouseMotion mm = new MouseMotion(city ,getComponents());
		
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		for (int i = 0; i<people.size(); i++) {
			g2.drawImage(people.get(i).getImage(),0,0,this);
		}
		repaint();
		
	}
}
