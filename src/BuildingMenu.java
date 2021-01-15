import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A Panel of Buttons of Buildings, that hopefully read the occupants in the building chosen...
 * @author Seth Miller
 *
 */
public class BuildingMenu extends JPanel implements ActionListener{
	private ArrayList <JButton> buildingBtns = new ArrayList <JButton>();
	private ArrayList <Building> buildingAccess = new ArrayList <Building>();

	private City city;
	Building[][] buildings;
	String output = "";
	

	/**
	 * Builds the menu based on the template of the city
	 * @param city - the template
	 */
		BuildingMenu(City city){
			this.city = city;
			init();
			
		}
		
		/**
		 * Build a configuration of JButtons to represent the buildings
		 */
		private void init() {
			this.setLayout(new GridBagLayout());
			
			buildings = city.getBuildings();
			for (int i = 0 ; i< buildings.length; i++)
				for (int j = 0; j<buildings[i].length; j++) {
					buildBtnsGBL(new JButton(buildings[i][j].getName()), i, j);
					buildingAccess.add(buildings[i][j]);
				}
			assert(buildingAccess.size() <= (buildings.length * buildings[0].length));
		}
		
		/**
		 * Shows the current Building selection
		 */
		public void paintComponent (Graphics g) {
			g.drawString("Selected Building:", 0,500);
			g.drawString(output, 0, 510);
		}

		/**
		 * Formats the given buttons into the address of the configuration
		 * @param j - the Button to put into the configuration
		 * @param x - the x index in the configuration
		 * @param y - y index in the configuration
		 */
		private void buildBtnsGBL(JButton j, int x, int y) {
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = x;
			gbc.gridy = y;
			j.addActionListener(this);
			buildingBtns.add(j);
			this.add(j, gbc);
		}

		@Override
		/**
		 * Represents how when the button's pushed, that is the selected Building, updating accordingly
		 */
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for ( int i = 0; i< buildingBtns.size(); i++) {
				if (e.getSource()==buildingBtns.get(i)) {
					System.out.println(buildingAccess.get(i).readOccupants());
					output = buildingAccess.get(i).readOccupants();
				}
			}
			repaint();
		}
}
