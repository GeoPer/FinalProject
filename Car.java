

public class Car {
	private String manufacturer;
	private String model;
	private String engine;
	private int maxSpeed;
	private String[] tyres= {"SuperSoft","Soft","Medium","Hard","Wet"};
	private String tyresType;
	static int counter=0;
	static Car cars[] = new Car [20];

	public Car(String manufacturer, String model, String engine, int maxSpeed, int tyresNo) {
		this.manufacturer=manufacturer;
		this.model=model;
		this.engine=engine;
		this.maxSpeed=maxSpeed;
		this.tyresType=tyres[tyresNo];
		cars[counter++]=this;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getTyresType() {
		return tyresType;
	}

	public void setTyresType(String tyresType) {
		this.tyresType = tyresType;
	}

	@Override
	public String toString() {
		return "Car [manufacturer=" + manufacturer + ", model=" + model + ", engine=" + engine + ", maxSpeed="
				+ maxSpeed + "km/h"+ ", tyresType=" + tyresType + "]";
	}

}
