import java.util.ArrayList;

/**
 * Represents the absence of a building
 * @author Seth Miller
 * @version 3.0.0
 */
public class EmptyLot extends Building{
	private ArrayList occupants = new ArrayList<Person>();
	private int row;
	private int column;
	String imgUrl =  "EmptyLot.png";
	
	EmptyLot(){
		this.name = "Empty Lot";
	}
	
	/**
	 * Helps keep track of which index in City Class' buildings array where this is kept
	 */
	public void setAddress(int street, int buildingNum) {
		row = street;
		column = buildingNum;
	}
	
	/**
	 * Represents how people can still inhabit empty lots
	 */
	public void addOccupant(Person add) {
		occupants.add(add);
	}
	
	/**
	 *  Getter for url for the image, because using Building's would use Building's URL
	 * @return - URL for image for this class
	 */
	public String getURL() {
		return this.imgUrl;
	}
}
