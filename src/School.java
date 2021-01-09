import java.util.ArrayList;
/**
 * Models a School object, holding teachers and students
 *@author Seth Miller
 *@version 1.0.0, 07 January 2021
 */
public class School extends Building {
	//Represent how schools have teachers and students
	private ArrayList teachers = new ArrayList<Teacher>();
	private ArrayList students = new ArrayList<Kid>();
	
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
	 * Initializes School with given name and address
	 * @param name is the name of the School
	 * @param address is the label of the address
	 */
	School(String name, int street, int buildingNum){
		super(name, street, buildingNum);
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
}
