package examen;

import java.io.Serializable;

//nota 4 punctul e-> Implements Serializable, Cloneable, 
public class Car implements Vehicle, Serializable, Cloneable{

	/* Nota 3
	 * Create public class Car which must implement Vehicle Interface
	 * and it must be inserted 3 private fields: 
	 * weight - float 
	 * price - double
	 * model - string
	 */
	
	private static final long serialVersionUID = 1L;
	private float weight;
	private double price;
	private String model;
	
	/* Nota 4 implement getters and setters punctul b
	 * 
	 * getters*/
	public float getWeight() {
		return weight;
	}

	public double getPrice() {
		return price;
	}

	public String getModel() {
		return model;
	}

	/* Nota 4 punctul d
	 * setters
	 * the setters should throw Exception if the constraints are not fulfilled:
	 * 
	 * model different than null and model string length greater than 1
	 * price and weight greater than 0 each
	 * */
	
	//greutate mai mare strict decat 0
	public void setWeight(float weight) throws Exception {
		if (weight <= 0) {
			throw new Exception ();
		} else 
		this.weight = weight;
	}

	//pret mai mare strict decat 0
	public void setPrice(double price) throws Exception {
		if (price <= 0) {
			throw new Exception ();
		} else 
		this.price = price;
	}

	//model diferit de null si mai mare de 1
	public void setModel(String model) throws Exception {
		if (model == null || model.length() <= 1) {
			throw new Exception();
		} else
		this.model = model;
	}

	/* nota 4 punctul c
	 * Override implementation for the getDetails() method (from the Vehicle interface) to return the model String
	 * */
	@Override
	public String getDetails() {
		return String.valueOf(model);
	}

	/*nota 4 punctul b default constructor (without parameters); There is no constructor with parameters
	 * */
	public Car() {
	}

	//Nota 4 punctul e continuare -> Override the implementation for equals(), hashCode(), and clone() methods in the right way
	
	//hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(weight);
		return result;
	}

	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Car))
			return false;
		Car other = (Car) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))
			return false;
		return true;
	}

//	//clone gresit -> shallow copy
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}

	//clone
	@Override 
	protected Car clone()
	{
		Car c =  new Car();
		try {
			c.setWeight(weight);
			c.setPrice(price);
			c.setModel(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
