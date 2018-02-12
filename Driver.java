
public class Driver {

	private String name;
	private short rankedPosition;
	private short age;
	private double lapTime;
	private short racingNumber;
	private Car car;
	static int counter=0;
	static Driver drivers[] = new Driver [20];

	public Driver(String name, short age, short racingnumber, Car car, double laptime) {
		this.name=name;
		this.age=age;
		this.racingNumber=racingnumber;
		this.car=car;
		this.lapTime=laptime;
		drivers[counter++]=this;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getRankedPosition() {
		return rankedPosition;
	}

	public void setRankedPosition(short rankedPosition) {
		this.rankedPosition = rankedPosition;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public double getLapTime() {
		return lapTime;
	}

	public void setLapTime(double lapTime) {
		this.lapTime = lapTime;
	}

	public short getRacingNumber() {
		return racingNumber;
	}

	public void setRacingNumber(short racingNumber) {
		this.racingNumber = racingNumber;
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", rankedPosition=" + rankedPosition + ", age=" + age + ", lapTime=" + getLapTime()
				+ ", racingNumber=" + racingNumber + ", Car= " + getCar().getManufacturer() +"]";
	}


}
