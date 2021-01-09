import java.util.ArrayList;

/**
 * This class models a City, holding buildings and people
 * @author Seth Miller
 *@version 1.0.0, 07 January 2021
 */
public class City {
	private String name;
	//Represents a collection of streets
	//Each street a collection of buildings
	private ArrayList <Building>[] buildings;
	private static int currBlock = 0;
	private ArrayList people =  new ArrayList <Person>();
	
	/**
	 * Initialize City given no parameters
	 */
	City(){
		name = "City";
		init();
	}
	
	/**
	 * Initialize the City given the name
	 * @param name - specifies the name of the City
	 */
	City(String name){
		this.name = name;
		init();
	}
	
	/**
	 * Initialize the City given the name
	 * @param name - specifies the name of the City
	 */
	City(String name, int numStreets){
		this.name = name;
		init();
	}
	
	private void init() {
		buildings = new ArrayList[5];
		//City Hall should wind up at buildings [0][0]
		populateCity(new CityHall(this.name),0);
		//School should wind up at buildings [0][1]
		populateCity(new School(this.name+" School"), 0);
		
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
		if (add instanceof Police)
			buildings[0].get(0).addOccupant(add);
		else {
			//unless a specific address is given, defaults to be put in school for simplicity
			buildings[0].get(1).addOccupant(add);
		}
			
	}
	
	/**
	 * Models how new people can move into the city
	 * @param add - a new person (or even a Teacher, Police or a Kid) for the people array
	 */
	public void populateCity(Person add, int street, int buildingNum) {
		assert(street>=0 && street < buildings.length && buildingNum >= 0 && buildingNum < buildings[street].size());
		people.add(add);
		buildings[0].get(0).addOccupant(add);
	}
	
	/**
	 * Represent how new Buildings can be built, defaulting on the emptiest street
	 * @param add - building to add to buildings array
	 */
	public void populateCity(Building add) {
		buildings[currBlock++].add(add);
		if (currBlock>=buildings.length) {
			currBlock = 0;
		}
	}
	
	/**
	 * Represent how new Buildings can be built, defaulting on the emptiest street
	 * @param add - building to add to buildings array
	 * @param street - the street (ArrayList) to place the new Building
	 */
	public void populateCity(Building add, int street) {
		//to ensure valid streets are chosen
		assert(street >= 0 && street < buildings.length);
		buildings[street].add(add);
	}
	
	
	/**
	 * works as a toString for the occupants in buildings
	 * @return passBack - an account of all occupants in each building
	 */
	public String readCityPopulus() {
		String passBack = "";
		for (int i = 0; i < buildings.length; i++) {
			for (int j = 0; j < buildings[i].size(); j++) {
				passBack+=buildings[i].get(j).readOccupants() +"\n";
			}
		}
		return passBack;
	}
}
