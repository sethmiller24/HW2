import java.util.ArrayList;

/**
 * Models a Building class, that typically holds occupants
 * @author Seth Miller
 *@version 1.0.0, January 7th 2021
 */
public class Building {
	protected String name;
	private String address;
	//To help differentiate buildings with default names
	private static int buildingCount = 0;
	//represents people who are inside buildings
	private ArrayList occupants = new ArrayList<Person>();
	String imgUrl = "Building.png";
	
	/**
	 * Initialize Building without parameters
	 */
Building(){
	name = "[Building "+ (++buildingCount)+"]";
	address = "[Address]";
}

/**
 * Initializes Building with given name
 * @param name is the name of the School
 */
Building(String name){
	//there needs to be content to save
	assert(name.length()>0);
	this.name = name;
	address = "[Address]";
}

/**
 * Sets address based on ArrayList buildings location once built in City.Java
 * @param street - array index
 * @param buildingNum - arrayList index
 */
public void setAddress(int street, int buildingNum) {
	this.address = buildingNum + " " + street +" street";
}

/**
 * Represents how people can move into and live in buildings
 * @param add represents a person entering this building
 */
public void addOccupant(Person add) {
	occupants.add(add);
}

public boolean hasPerson(Person test) {
	for (int i = 0; i< occupants.size(); i++) {
		if (occupants.get(i).equals(test)) {
			return true;
		}
	}
	return false;
}

public boolean removeOccupant(Person rem) {
	for (int i = 0; i< occupants.size(); i++) {
		if (occupants.get(i).equals(rem)) {
			occupants.remove(i);
			return true;
		}
	}
	return false;
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
	
/**
 *  Getter for url for the image
 * @return - URL for image for this class
 */
public String getURL() {
	return this.imgUrl;
}

}
