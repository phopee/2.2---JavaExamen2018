package examen;


//Nota 5
/* a. Create public Class ElectricCar
 * must inherit the Car class and it adds the batteryLife - int field 
 * */
public class ElectricCar extends Car {

	
	private static final long serialVersionUID = 1L;
	private int batteryLife;
	
	//for this class fields it is mandatory to implement getters and setters
	public int getBatteryLife() {
		return batteryLife;
	}
	//the setter should throw exception if the constrints are not fulfilled:
	// - batteryLife greater than 0
	public void setBatteryLife(int batteryLife) throws Exception {
		if (batteryLife < 0) {
			throw new Exception();
		}
		this.batteryLife = batteryLife;
	}
	
	//Override virtual implementation for the getDetails() method (from the Vehicle interface and Car implementation ) ,
	// to return the batteryLife as a string.
	@Override
	public String getDetails() {
		return String.valueOf(batteryLife);
	}
	
	
}
