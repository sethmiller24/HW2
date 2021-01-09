/**
 * Models Police Class who uniquely have police ranks
 *@author Seth Miller
 *@version 1.0.0, 07 January 2021
 */
public class Police extends Person implements Employee{
	private int ID;
	//ensure School district employees hold unique IDs from another
	private static int IDcounter = 10000;
	//Represents hourly wage
	private int payRate;
	//represents sum of income made
	private int earnings = 0;
	//Represents rank in police force, determined by payRate
	PoliceRole role;
	
	/**
	 * Implements Police with no parameters
	 */
	Police(){
		super();
		init();
	}
	
	/**
	 * Implements Police based on payRate
	 * @param payRate - hourly wage
	 */
	Police(int payRate){
		super();
		init();
		this.payRate = payRate;
		setRole();
	}
	
	/**
	 * Implements Police based on name and age
	 * @param name - Cop's name
	 * @param age - Cop's age
	 */
	Police(String name, int age){
		super(name,age);
		init();
	}
	
	/**
	 * Implements Police based on payRate, name and age
	 * @param payRate - hourly wage
	 * @param name - Cop's name
	 * @param age - Cop's age
	 */
	Police(int payRate,String name, int age){
		super(name,age);
		init();
		this.payRate = payRate;
		setRole();
	}
	
	/**
	 * Helper function - Sets default parameters for Police class
	 */
	private void init() {
		//Create unique police ID
		ID = IDcounter++;
		payRate = 13;
		earnings = 0;
		setRole();
		//default all police phone numbers to 911
		phoneNum = "911";
	}
	
	/**
	 * set Police's role based on the current pay rate
	 * Higher payRate, means higher role
	 */
	private void setRole() {
		if (payRate>40)
			role = PoliceRole.Chief;
		else if (payRate>30)
			role = PoliceRole.Captain;
		else if (payRate > 20)
			role = PoliceRole.Sargent;
		else
			role = PoliceRole.Patrol;
	}
	
	/**
	 * Represents different roles in the police force
	 */
	public enum PoliceRole {
		Patrol, Sargent, Captain, Chief
	}
	
	/**
	 * @return a string compiling all Police attributes
	 */
	public String toString() {
		return super.toString() + " | ID:" + ID +" | Position: " + role;
	}
	
	/**
	 * Implements Employee's getPaid()
	 * Represents how Employees can get money from their job
	 * @return a string showing payRate and earnings
	 */
	public String getPaid() {
		earnings+=payRate;
		return (name+ " gets paid $"+payRate+ " and now has $"+ earnings);
	}

	/**
	 * Getter for ID
	 * @return ID - Police's ID
	 */
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	/**
	 * Getter for earnings
	 * @return earnings - Police's earnings
	 */
	public int getEarnings() {
		// TODO Auto-generated method stub
		return earnings;
	}

}
