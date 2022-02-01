public class Vehicle implements Comparable<Vehicle> {
	//variables for vehicle class
	private String make;
	private String model;
	private double milesPerGallon;
	//setter
	public Vehicle() {
		this.make = "";
		this.model = "";
		this.milesPerGallon = 0;
	}
	//setter w given info
	public Vehicle(String make, String model, double milesPerGallon) {
		this.make = make;
		this.model = model;
		this.milesPerGallon = milesPerGallon;
	}
	//getters
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public double getMilesPerGallon() {
		return milesPerGallon;
	}
	
	@Override //compare method to sort vehicles by mpg in ascending order
	public int compareTo(Vehicle o) {
		int comparedSize = (int) o.getMilesPerGallon();
		if (this.milesPerGallon > comparedSize) {
			return 1;
		} else if (this.milesPerGallon == comparedSize) {
			return 0;
		} else
			return -1;
	}
	
	@Override //tostring to display make, model, mpg
	public String toString() {
		return ("Make: " + getMake() + " Model: " + getModel() + " Miles Per Gallon: " + getMilesPerGallon());
	}

} //class end