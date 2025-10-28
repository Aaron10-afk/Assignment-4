/*
 * Class: CMSC203 
 * Instructor:Farnez Eivazi
 * Description: Represents a Property with name, city, rent amount, owner, and a Plot.
 * Due: 10/27/2025
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Aaron Brezovec
*/
public class Property {
	private String propertyName, city, owner;
	private double rentAmount;
	private Plot plot;

	public Property() {
		this("", "", 0.0, "", 0, 0, 1, 1);
	}

	public Property(String propertyName, String city, double rentAmount, String owner) {
		this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
	}

	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width,
			int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}

	public Property(Property otherProperty) {
		this(otherProperty.propertyName, otherProperty.city, otherProperty.rentAmount, otherProperty.owner,
				otherProperty.plot.getX(), otherProperty.plot.getY(), otherProperty.plot.getWidth(),
				otherProperty.plot.getDepth());
	}
	// getters

	public Plot getPlot() {
		return new Plot(plot);
	}

	public String getPropertyName() {
		return propertyName;
	}

	public String getCity() {
		return city;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public String getOwner() {
		return owner;
	}

	// toString
	@Override
	public String toString() {
	    return propertyName + "," + city + "," + owner + "," + rentAmount;
	}
}