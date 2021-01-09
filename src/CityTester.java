
public class CityTester {

	public static void main(String[] args) {
		City Bellevue = new City("Bellevue");
		
		for (int i = 0; i < 3; i++) {
			Bellevue.populateCity(new Building());
			Bellevue.populateCity(new Person("Test"+i, i+20,7864255));
			Bellevue.populateCity(new Kid());
			Bellevue.populateCity(new Police());
			Bellevue.populateCity(new Teacher());
		}
		
		Bellevue.populateCity(new Building("McDonald's", "105 Burger Street"));
		Bellevue.populateCity(new Teacher("Mr. Meaty", 4));
		Bellevue.populateCity(new Police(40,"Mr. Sheriff",20));
		Bellevue.populateCity(new Kid("Diet Cookie","Diet Cookie Boy",10));
		Bellevue.populateCity(new Kid("Big Jelly Bean","Jelly Bean Boy",10));
		Bellevue.populateCity(new Kid());
		System.out.println(Bellevue.readCityPopulus());
		System.out.println(Bellevue.payEmployees());
		System.out.println(Bellevue.payEmployees());
	}

}
