
public class Circle {
	
	protected double cXcoord;
	protected double cYcoord;
	protected double cRadius;
	protected double area;
	private double tempArea;
	protected double tempRadius;
	
	public Circle (double xCoord, double yCoord, double radius) {
		this.cXcoord = xCoord;
		this.cYcoord = yCoord;
		this.cRadius = radius;
	}
	
	public void setRadius(double newRadius) {
		this.cRadius = newRadius;
	}
	
	public double getRadius() {
		return this.cRadius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		// If obj isn't of parent Circle or subclasses, 
		// then they cannot be equal. Return false.
		if (obj instanceof Circle) {
			Circle other = (Circle) obj;
			return area == other.area 
				&& cRadius == other.cRadius
				&& cXcoord == other.cXcoord
				&& cYcoord == other.cYcoord;
		}
		return false;
	}

	public double getArea() {
		this.area = Math.PI*cRadius*cRadius;
		return area;
	}
	
	@Override
	public String toString() {
		this.tempArea = this.getArea();
		return String.format("This circle has center (%.2f, %.2f) with radius of %.2f and Area:%.2f", cXcoord, cYcoord, cRadius, tempArea);
	}
}
