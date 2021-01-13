import java.awt.Image;
import java.util.ArrayList;

import javax.print.DocFlavor.URL;
/**
 * Models a School object, holding teachers and students
 *@author Seth Miller
 *@version 1.0.0, 07 January 2021
 */
public class School extends Building {
	//Represent how schools have teachers and students
	private ArrayList teachers = new ArrayList<Teacher>();
	private ArrayList students = new ArrayList<Kid>();
	private String imgUrl =  "School.png";
	
	/**
	 * Initializes School with no parameters
	 */
	School(){
		super();
		this.name = "[School]";
	}

	/**
	 * Initializes School with the name of the city
	 * @param name is the name of the School
	 */
	School(String name){
		super();
		this.name = name;
	}
	
	
	/**
	 * Sorts into registry of teachers and student if person is a teacher or kid
	 * @param add represents a person entering this school
	 */
	public void addOccupant(Person add) {
		super.addOccupant(add);
		if (add instanceof Teacher)
			teachers.add(add);
		else if(add instanceof Kid)
			students.add(add);
	}

	/**
	 * @return passBack - list of all occupants in the school
	 */
	public String readOccupants() {
		String passBack = super.readOccupants();
		if(teachers.size()>0)
			passBack+=("\nTeachers:");
		for (int i = 0; i < teachers.size(); i++)
			passBack+=(teachers.get(i).toString());
		if(students.size()>0)
			passBack+=("\nStudents:");
		for (int i = 0; i < students.size(); i++) 
			passBack+=(students.get(i).toString());
		return passBack;
	}
	
	/**
	 *  Getter for url for the image, because using Building's would use Building's URL
	 * @return - URL for image for this class
	 */
	public String getURL() {
		return this.imgUrl;
	}
}
