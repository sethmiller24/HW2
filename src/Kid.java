import java.awt.Image;

/**
 * Models Kid class, who are unique in how they alone can like candy
 *@author Seth Miller
 *@version 1.0.0, 07 January 2021
 */
public class Kid extends Person{
	private String favCandy;
	private Image imgUrl =   toolkit.createImage("Kid.png");
	
	/**
	 * Implements Kid class with no parameters
	 */
	Kid(){
		super("Kid "+numCount++,5);
		favCandy = "Pure Sugar";
	}
	
	/**
	 * Implements Kid class based on favorite candy
	 * @param candy - Kid's favorite candy
	 */
	Kid(String candy){
		super("Kid "+numCount++,5);
		favCandy = candy;
	}
	
	/**
	 * Implements Kid class based on name and age
	 * @param name - Kid's name
	 * @param age - Kid's age
	 */
	Kid(String name, int age){
		super(name, age);
		//for accuracy, make sure valid ages of children
		assert (age>=0 && age <18);
		favCandy = "Pure Sugar";
	}
	/**
	 * Implements Kid class based on name, candy and age
	 * @param candy - Kid's favorite candy
	 * @param name - Kid's name
	 * @param age - Kid's age
	 */
	Kid(String candy,String name, int age){
		super(name,age);
		//for accuracy, make sure valid ages of children + a text in candy
		assert (age>=0 && age <18 && candy.length()>0);
		favCandy = candy;
	}
	
	/**
	 * Implements Kid class based on name, candy and age
	 * @param candy - Kid's favorite candy
	 * @param name - Kid's name
	 * @param age - Kid's age
	 * @param phoneNum - Kid's phone number
	 */
	Kid(String candy,String name, int age, int phoneNum){
		super(name,age, phoneNum);
		//for accuracy, make sure valid ages of children + a text in candy
		assert (age>=0 && age <18 && candy.length()>0);
		favCandy = candy;
	}
	
	public String getCandy() {
		return favCandy;
	}
	
	/**
	 * Getter for imgUrl
	 * @return the image representing Kid - for UI purposes
	 */
	public Image getImage() {
		return imgUrl;
	}
}
