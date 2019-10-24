package project1;

public class Car implements IDeeplyCloneable<Car>, IAggregable<Car, Integer> {

	private String brand;
	private int model;
	
	public Car() {
	}

	public Car(String brand, int model) {
		this.brand = brand;
		this.model = model;
		
	}

	@Override
	public Integer aggregate(Integer intermediateResult) {
		if (intermediateResult == null) {
			return model;
		}
		if (model > intermediateResult) {
			return intermediateResult;
		} else {
			return model;
		}
	}

	@Override
	public Car deepClone() {
		Car newCar = new Car(this.brand, this.model);
		return newCar;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(int model) {
		this.model = model;
	}

	
	public String getBrand() {
		return brand;
	}

	public int getModel() {
		return model;
	}


}
