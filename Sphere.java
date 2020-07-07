
public class Sphere extends Circle {
	private double cZcoord;
	private double tempArea;
	private double tempVolume;
	public Sphere (double xCoord, double yCoord, double zCoord, double radius) {
		super(xCoord, yCoord, radius);
		this.cZcoord = zCoord;
	}
	
	public boolean myequals(Sphere obj) {
		// Assuming that only Sphere objects will be passed through
		if (cRadius != obj.cRadius || cXcoord != obj.cXcoord || cYcoord != obj.cYcoord) {
			return false;
		}
		return true; // They are equal if it fails all of the checks
	}
	
	public double getArea() {
		return (4 * Math.PI * this.cRadius * this.cRadius);
	}
	
	public double getVolume() {
		return ((4 * Math.PI * this.cRadius * this.cRadius * this.cRadius)/3);
	}
	
	@Override
	public String toString() {
		this.tempArea = this.getArea();
		this.tempVolume = this.getVolume();
		return String.format("This sphere has center (%.2f, %.2f, %.2f) with radius of %.2f.\nArea:%.2f, Vol:%.2f", this.cXcoord, this.cYcoord, this.cZcoord, this.cRadius, this.tempArea, this.tempVolume);
		
	}
}
	
	


