import java.util.ArrayList;

/**
 * Models a Building class, that typically holds occupants
 * @author Seth Miller
 *@version 1.0.0, January 7th 2021
 */
public class Building {
	private String name;
	private String address;
	//To help differentiate buildings with default names
	private static int buildingCount = 0;
	//represents people who are inside buildings
	private ArrayList occupants = new ArrayList<Person>();

	/**
	 * Initialize Building without parameters
	 */
Building(){
	name = "[Building "+ (++buildingCount)+"]";
	address = "[Address]";
}

/**
 * Initializes Building with given name and address
 * @param name is the name of the School
 * @param address is the label of the address
 */
Building(String name, String address){
	this.name = name;
	this.address = address;
}

/**
 * Represents how people can move into and live in buildings
 * @param add represents a person entering this building
 */
public void addOccupant(Person add) {
	occupants.add(add);
}

/**
 * 
 * @return sumOcc - list of occupants in the building
 */
public String readOccupants() {
	String sumOcc = ("\nOccupants in " + name+ "\n---------------------------------------------");
	for (int i = 0; i<occupants.size(); i++) {
		sumOcc += (occupants.get(i).toString());
	}
	return sumOcc;
}
	
}
