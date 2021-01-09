/**
 * Models Kid class, who are unique in how they alone can like candy
 *@author Seth Miller
 *@version 1.0.0, 07 January 2021
 */
public class Kid extends Person{
	String favCandy;
	
	/**
	 * Implements Kid class with no parameters
	 */
	Kid(){
		super();
		favCandy = "Pure Sugar";
	}
	
	/**
	 * Implements Kid class based on favorite candy
	 * @param candy - Kid's favorite candy
	 */
	Kid(String candy){
		super();
		favCandy = candy;
	}
	
	/**
	 * Implements Kid class based on name and age
	 * @param name - Kid's name
	 * @param age - Kid's age
	 */
	Kid(String name, int age){
		super(name, age);
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
		favCandy = candy;
	}
}
