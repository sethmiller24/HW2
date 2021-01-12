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
	private Building[][] buildings;
	private int maxBuildings;
	private int currNumBuildings;
	private ArrayList people =  new ArrayList <Person>();
	private CityComponent UI;
	java.net.URL backgroundImgUrl = getClass().getResource("MapBackground.jpeg");
	
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
		presetCity();
		showWindow();
	}
	
	/**
	 * Initialize the City given the name
	 * @param name - specifies the name of the City
	 */
	City(String name, int numStreets){
		this.name = name;
		init();
		buildings = new Building [numStreets][5];
		maxBuildings = numStreets*5;
		presetCity();
		showWindow();
	}
	
	private void init() {
		//preset to 5 streets x 5 buildings
		buildings = new Building [5][5];
		maxBuildings = 25;
		currNumBuildings = 0;
	
	}
	
	/**
	 * 
	 */
	private void presetCity() {
		for (int i = 0; i< buildings.length; i++) {
			for (int j = 0; j<buildings[i].length; j++) {
				buildings[i][j] = new EmptyLot();
			}
		}
		//City Hall should wind up at buildings [0][0]
		this.populateCity(new CityHall(this.name));
		//School should wind up at buildings [0][1]
		this.populateCity(new School(this.name+" School"));
	}
	
	public void showWindow() {
		assert(buildings.length > 0);
		UI = new CityComponent();
		UI.showScreen(buildings.length, buildings[0].length);
		UI.setButtons(buildings);
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
			//Kids and Teachers default to being put in school for simplicity
			buildings[0][0].addOccupant(add);
		else if (add instanceof Teacher || add instanceof Kid)
			//Kids and Teachers default to being put in school for simplicity
			buildings[0][1].addOccupant(add);
		else {
			//otherwise, default to be put in the most recently built building
			buildings[(currNumBuildings-1)/5][(currNumBuildings-1)%5].addOccupant(add);
		}
			
	}
	
	/**
	 * Represent how new Buildings can be built, defaulting on the emptiest street
	 * @param add - building to add to buildings array
	 * @return false - there is no more space for buildings in the array
	 * @return true - added add to the next available empty plot
	 */
	public boolean populateCity(Building add) {
		if(currNumBuildings < maxBuildings) {
			for (int i = 0; i<buildings.length; i++)
				for (int j = 0; j< buildings[i].length; j++) {
					if (buildings[i][j]instanceof EmptyLot) {
						buildings[i][j] = add;
						add.setAddress(i,j);
						currNumBuildings++;
						return true;
					}
				}	
		}
			return false;
	}	
	
	/**
	 * works as a toString for the occupants in buildings
	 * @return passBack - an account of all occupants in each building
	 */
	public String readCityPopulus() {
		String passBack = "";
		for (int i = 0; i < buildings.length; i++) {
			for (int j = 0; j < buildings[i].length; j++) {
				if (buildings[i][j]!=null)
					passBack+=buildings[i][j].readOccupants() +"\n";
			}
		}
		return passBack;
	}
}
