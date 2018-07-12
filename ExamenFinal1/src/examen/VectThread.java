//nota 8 - de verificat

package examen;

import java.util.List;

public class VectThread implements Runnable {
	private List<Vehicle> carsList;
	private double avgWeight;

	@Override
	public void run() {
		double sum = 0;
		for (Vehicle vehicle : carsList) {
			Car car = new Car();
			sum += car.getWeight();
		}
		avgWeight = sum / carsList.size();
	}

	public VectThread(List<Vehicle> carsList) {
		carsList = Utils.readBinaryCars("carsList.dat");
		
	}

	public List<Vehicle> getCarsList() {
		return carsList;
	}

	public double getAvgWeight() {
		return avgWeight;
	}

	public void setCarsList(List<Vehicle> carsList) {
		this.carsList = carsList;
	}

	public void setAvgWeight(double avgWeight) {
		this.avgWeight = avgWeight;
	}

	
}
