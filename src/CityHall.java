import java.util.ArrayList;

/**
 * Models a City Hall, mostly acting as a precinct, holding police
 * @author Seth Miller
 *@version 1.0.0, January 7th 2021
 */
public class CityHall extends Building {
	//represents how City Hall is where police reside...?
	private ArrayList officers = new ArrayList<Police>();
	java.net.URL imgUrl = getClass().getResource("CityHall.png");
	
	
	/**
	 * Initialize CityHall without parameters
	 */
	CityHall(){
		super();
		this.name = "City Hall";
	}
	
	/**
	 * Initialize CityHall given a name
	 * @param name - the name of the city this city hall belongs to
	 */
	CityHall(String name){
		super();
		this.name = name + " City Hall";
	}
}
