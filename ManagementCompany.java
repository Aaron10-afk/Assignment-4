/*
 * Class: CMSC203 
 * Instructor:Farnez Eivazi
 * Description: ManagementCompany that manages up to MAX_PROPERTY Property objects.
 * Due: 10/27/2025
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Aaron Brezovec
*/
public class ManagementCompany {
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;

	private String name;
	private String taxID;
	private double mgmFeePer;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;

	public ManagementCompany() {
		this("", "", 0.0);
	}

	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		this.numberOfProperties = 0;
	}

	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
		this.numberOfProperties = 0;
	}

	public ManagementCompany(ManagementCompany otherCompany) {
		this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer, otherCompany.plot.getX(),
				otherCompany.plot.getY(), otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
		for (int i = 0; i < otherCompany.getPropertiesCount() && i < MAX_PROPERTY; i++) {
			Property p = otherCompany.getProperties()[i];
			if (p != null) {
				this.properties[i] = new Property(p);
				this.numberOfProperties++;
			}
		}
	}

	public int addProperty(String name, String city, double rent, String owner) {
		Property p = new Property(name, city, rent, owner);
		return addProperty(p);
	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property p = new Property(name, city, rent, owner, x, y, width, depth);
		return addProperty(p);
	}

	public int addProperty(Property property) {
		if (property == null)
			return -2;
		if (isPropertiesFull())
			return -1;
		if (!plot.encompasses(property.getPlot()))
			return -3;
		for (int i = 0; i < numberOfProperties; i++) {
			if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
			}
		}
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] == null) {
				properties[i] = new Property(property);
				numberOfProperties++;
				return i;
			}
		}
		return -1;
	}

	public double getTotalRent() {
		double total = 0.0;
		for (Property p : properties) {
			if (p != null)
				total += p.getRentAmount();
		}
		return total;
	}

	public Property getHighestRentProperty() {
		if (numberOfProperties == 0)
			return null;
		int idx = getHighestRentPropertyIndex();
		return properties[idx];
	}

	private int getHighestRentPropertyIndex() {
		int highestIndex = -1;
		double max = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < properties.length; i++) {
			Property p = properties[i];
			if (p != null && p.getRentAmount() > max) {
				max = p.getRentAmount();
				highestIndex = i;
			}
		}
		return highestIndex;
	}

	public void removeLastProperty() {
		if (numberOfProperties == 0)
			return;
		for (int i = properties.length - 1; i >= 0; i--) {
			if (properties[i] != null) {
				properties[i] = null;
				numberOfProperties--;
				break;
			}
		}
	}

	public boolean isPropertiesFull() {
		return numberOfProperties >= MAX_PROPERTY;
	}

	public int getPropertiesCount() {
		return numberOfProperties;
	}

	public boolean isMangementFeeValid() {
		return mgmFeePer >= 0.0 && mgmFeePer <= 100.0;
	}

	public String toString() {
		String result = "List of the properties for " + name + ", taxID: " + taxID + "\n";
		result += "______________________________________________________\n";
		for (Property p : properties) {
			if (p != null) {
				result += p.toString() + "\n"; // used Property.toString() here
			}
		}
		result += "______________________________________________________\n\n";
		double totalFee = getTotalRent() * (mgmFeePer / 100.0);
		result += " total management Fee: " + String.format("%.2f", totalFee);
		return result;
	}

	public double getMgmFeePer() {
		return mgmFeePer;
	}

	public String getName() {
		return name;
	}

	public Plot getPlot() {
		return new Plot(plot);
	}

	public Property[] getProperties() {
		return properties;
	}

	public String getTaxID() {
		return taxID;
	}
}