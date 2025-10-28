/*
 * Class: CMSC203 
 * Instructor:Farnez Eivazi
 * Description: Represents a rectangular plot with x,y (upper-left), width, depth
 * Due: 10/27/2025
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Aaron Brezovec
*/

public class Plot {
	private int x, y, width, depth;

	public Plot() {
		this(0, 0, 1, 1);
	}

	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	public Plot(Plot otherPlot) {
		this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
	}

	public boolean encompasses(Plot plot) {
		if (plot == null)
			return false;
		if (plot.x >= x && plot.y >= y && plot.x + plot.width <= x + width && plot.y + plot.depth <= y + depth) {

			return true;

		} else {

			return false;

		}
	}

	// getters

	public int getDepth() {
		return depth;
	}

	public int getWidth() {
		return width;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean overlaps(Plot plot) {
		if (plot == null)
			return false;
		if (plot.x + plot.width <= x || plot.x >= x + width || plot.y + plot.depth <= y || plot.y >= y + depth) {

			return false;

		} else {

			return true;
		}
	}

	// setters

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}