
public class Car {
	private String manufacturer;
	private String model;
	private String engine;
	private int maxSpeed;
	private String[] tires= {"SuperSoft","Soft","Medium","Hard","Wet"};
	private String tiresType;
	static int counter=0;
	static Car cars[] = new Car [20];
	
	public Car(String manufacturer, String model, String engine, int maxSpeed, int tiresNo) {
		this.manufacturer=manufacturer;
		this.model=model;
		this.engine=engine;
		this.maxSpeed=maxSpeed;
		this.tiresType=tires[tiresNo];
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

	public String getTiresType() {
		return tiresType;
	}

	public void setTiresType(String tiresType) {
		this.tiresType = tiresType;
	}

	@Override
	public String toString() {
		return "Car [manufacturer=" + manufacturer + ", model=" + model + ", engine=" + engine + ", maxSpeed="
				+ maxSpeed + ", tiresType=" + tiresType + "]";
	}
	
}
