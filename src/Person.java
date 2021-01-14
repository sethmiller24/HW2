import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.print.DocFlavor.URL;
import javax.swing.JComponent;

/**
 * Models Person class, represents how people typically have a name and age
 *@author Seth Miller
 *@version 1.0.0, 07 January 2021
 *
 */
public class Person extends JComponent{
	protected String name;
	private int age;
	//counter to ensure unique phone numbers and default names
	protected static int numCount = 1;
	protected String phoneNum;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Image imgUrl = toolkit.createImage("Person.png");
	
	/**
	 * Initialize Person with no parameters
	 */
	Person(){
		init();
	}
	
	/**
	 * Initialize Person based on name and age
	 * @param name - person's name
	 * @param age - person's age
	 */
	Person(String name, int age){
		init();
		//ensure there is a valid age and the name is not empty
		assert(age>=0 && name.length()>0);
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Initialize Person based on name, age and phone number
	 * @param name - person's name
	 * @param age - person's age
	 * @param phoneNum - person's phone number (but will convert to (509) number
	 */
	Person(String name, int age, int phoneNum){
		init();
		//ensure there is a valid age and the name is not empty
		assert(age>=0 && name.length()>0);
		this.name = name;
		this.age = age;
		this.phoneNum = ((phoneNum%10000000)+10000000)+"";
		this.phoneNum = "(509)-"+this.phoneNum.substring(1,4)+"-"+this.phoneNum.substring(4);
	}
	
	/**
	 * Helper function - Sets default parameters for Person
	 */
	private void init() {
		age = 18;
		name = "Person " + (numCount);
		phoneNum = ""+((numCount++) +1000000);
		phoneNum = "(509)-" + phoneNum.substring(0, 3) +"-"+ phoneNum.substring(3);
	}

	/**
	 * Getter for Name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return a string compiling the name, age and phone number
	 */
	public String toString() {
		return "\n"+name + " | Age: "+ age + " | Phone #" + phoneNum;
	}
	
	/**
	 * Getter for imgUrl
	 * @return the image representing Teacher - for UI purposes
	 */
	public Image getImage() {
		return imgUrl;
	}

	
}
