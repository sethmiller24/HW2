import java.awt.Image;

/**
 *@author Seth Miller
 *@version 1.0.0, 07 January 2021
 *
 */
public class Teacher extends Person implements Employee{
	private int ID;
	//ensure School district employees hold unique IDs from another
	private static int IDcounter = 10000;
	//Represents hourly wage
	private int payRate;
	//represents sum of income made
	private int earnings = 0;
	//represents the grade the teacher teaches
	private gradeLevel grade;
	//represents level of education the teacher has
	private certLevel certification;
	private Image imgUrl =  toolkit.createImage("Teacher.png");
	
	
	/**
	 * Implements Teacher with no parameters
	 */
	Teacher(){
		super();
		init();
	}
	
	/**
	 * Implements Teacher based on grade and certification
	 * @param grade - teacher's grade they teach
	 * @param certification - teacher's certification level
	 */
	Teacher(int grade, int certification){
		super();
		init();
		setGradeLevel(grade);
		setCertification(certification);
		setPayRate();
	}
	
	/**
	 * Implements Teacher class based on name and age
	 * @param name - Teacher's name
	 * @param age - Teacher's age
	 */
	Teacher(String name, int age){
		super(name,age);
		init();
	}
	
	/**
	 * Implements Teacher class based on name, phone number and age
	 * @param name - Teacher's name
	 * @param age - Teacher's age
	 * @param phoneNum - Teacher's phone number
	 */
	Teacher(String name, int age, int phoneNum){
		super(name,age,phoneNum);
		init();
	}
	
	/**
	 * Implements Teacher class based on grade, certification, name and age
	 * @param grade - Teacher's grade they teach
	 * @param certification - Teacher's level of certification
	 * @param name - Teacher's name
	 * @param age - Teacher's age
	 */
	Teacher(int grade, int certification,String name, int age){
		super(name, age);
		init();
		setGradeLevel(grade);
		setCertification(certification);
		setPayRate();
	}
	
	/**
	 * Helper function - Sets default parameters for Police class
	 */
	private void init() {
		ID = IDcounter++;
		certification = certLevel.None;
		grade = gradeLevel.University;
		setPayRate();		
	}
	
	/**
	 * Will set the teacher's pay rate based around the current certification
	 * Higher certification means higher pay
	 */
	private void setPayRate() {
		if (certification.equals(certLevel.Masters))
			payRate = 50;
		else if (certification.equals(certLevel.Bachelors))
			payRate = 35;
		else
			payRate = 20;
		if (grade.equals(gradeLevel.University))
			payRate *= 1.25;
	}
	
	/**
	 * Will sort the teacher into the grade Pre-School, Elementary, Middle School, High School and University based on the gradeNum
	 * @param gradeNum - the grade
	 */
	private void setGradeLevel(int gradeNum) {
		if (gradeNum < 0)
			this.grade = gradeLevel.PreSchool;
		else if (gradeNum >= 0 && gradeNum <=5)
			this.grade = gradeLevel.Elementary;
		else if (gradeNum >= 6 && gradeNum <=8)
			this.grade = gradeLevel.MiddleSchool;
		else if (gradeNum >= 9 && gradeNum <=12)
			this.grade = gradeLevel.HighSchool;
		else
			this.grade = gradeLevel.University;			
	}
	
	/**
	 * Sets certification based around an int
	 * @param cert - helps determine the level of certification
	 */
	private void setCertification(int cert) {
		if (cert<0)
			certification = certLevel.None;
		else if (cert == 0)
			certification = certLevel.Bachelors;
		else
			certification = certLevel.Masters;
	}
	
	/**
	 * Represents the grades that teachers can teach
	 */
	public enum gradeLevel{
		PreSchool,Elementary,MiddleSchool,HighSchool, University
	}
	
	/**
	 * Represents different certification levels teachers can have
	 */
	public enum certLevel{
		None,Bachelors,Masters
	}	
	
	/**
	 * @return a string compiling all Teacher attributes
	 */
	public String toString() {
		return super.toString() + " | ID:" + ID +" | Grade: " + grade +" | Certification Level: " + certification;
	}
	
	/**
	 * Implements Employee's getPaid()
	 * Represents how Employees can get money from their job
	 * @return a string showing payRate and earnings
	 */
	public String getPaid() {
		earnings+=payRate;
		return (this.name+ " gets paid $"+payRate+ " and now has $"+ earnings);
	}

	/**
	 * Getter for ID
	 * @return ID - Teacher's ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Getter for earnings
	 * @return earnings - Teacher's earnings
	 */
	public int getEarnings() {
		// TODO Auto-generated method stub
		return earnings;
	}
	
	/**
	 * Getter for certification
	 * @return - a string version of the Enum for certification
	 */
	public String getCertLevel() {
		return this.certification.toString();
	}
	
	/**
	 * Getter for certification
	 * @return - a string version of the Enum for the teacher's grade level
	 */
	public String getGradeLevel() {
		return this.grade.toString();
	}
	
	/**
	 * Getter for imgUrl
	 * @return the image representing Teacher - for UI purposes
	 */
	public Image getImage() {
		return imgUrl;
	}

}
