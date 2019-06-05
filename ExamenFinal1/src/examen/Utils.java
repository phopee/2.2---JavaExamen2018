//partial corect, la examen a aparut cu x albastru (cod corect, dar nu era implementarea care se cerea).


//nota 6 si 7
package examen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
	private static List<Vehicle> electricCar = new ArrayList<>();
	
	public static List<Vehicle> createCars (int n) throws Exception {
		for (int i = 0 ; i < n; i++) {
			Car car = new Car();
			car.setWeight(1f);
			car.setPrice(2);
			car.setModel("BMW");
		}
		return electricCar;
	}
	
	public static List<Vehicle> readCars(String file){
		try {
			Scanner input = new Scanner(new File(file));
			input.useDelimiter("\n");
			while(input.hasNext()) {
				float weight = Float.parseFloat(input.next());
				double price = Double.parseDouble(input.next());
				String model = input.next();
				
				Car car = new Car();
				car.setWeight(weight);
				car.setPrice(price);
				car.setModel(model);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return electricCar;
	}
	
	public static void writeBinaryCars (String file, List<Vehicle> listP) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			for (Vehicle vehicle : listP) {
				objectOutputStream.writeObject(vehicle);
			}
			objectOutputStream.flush();
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Vehicle> readBinaryCars (String file){
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Car car = new Car();
			while (fileInputStream.available() > 0) {
				objectInputStream.readObject();
				electricCar.add(car);
			}
			objectInputStream.close();
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return electricCar;
	}
}
