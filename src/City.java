import java.util.ArrayList;

/**
 * This class models a City, holding buildings and people
 * @author Seth Miller
 *@version 1.0.0, 07 January 2021
 */
public class City {
	private String name;
	private ArrayList buildings = new ArrayList <Building>();
	private ArrayList people =  new ArrayList <Person>();
	
	/**
	 * Initialize City given no parameters
	 */
	City(){
		name = "City";
		populateCity(new CityHall());
		populateCity(new School(name+" School"));
	}
	
	/**
	 * Initialize the City given the name
	 * @param name - specifies the name of the City
	 */
	City(String name){
		this.name = name;
		populateCity(new CityHall(name));
		populateCity(new School(name+" School"));
	}
	
	/**
	 * for instances of Employee implementing Classes
	 * @return a string for all accounts of employees being paid
	 */
	public String payEmployees() {
		String passBack = "";
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i) instanceof Teacher || people.get(i) instanceof Police ) {
				passBack+=((Employee) people.get(i)).getPaid()+"\n";
			}			
		}
		return passBack;	
	}

	/**
	 * Models how new people can move into the city
	 * @param add - a new person (or even a Teacher, Police or a Kid) for the people array
	 */
	public void populateCity(Person add) {
		people.add(add);
		if (add instanceof Teacher)
			((Building) buildings.get(1)).addOccupant(add);
		else if (add instanceof Police)
			((Building) buildings.get(0)).addOccupant(add);
		else
		((Building) buildings.get(buildings.size()-1)).addOccupant(add);
	}
	
	/**
	 * Represent how new Buildings can be built
	 * @param add - building to add to buildings array
	 */
	public void populateCity(Building add) {
		buildings.add(add);
	}

	/**
	 * works as a toString for the occupants in buildings
	 * @return passBack - an account of all occupants in each building
	 */
	public String readCityPopulus() {
		String passBack = "";
		for (int i = 0; i < buildings.size(); i++) {
			passBack+=((Building) buildings.get(i)).readOccupants() +"\n";
		}
		return passBack;
	}
}
