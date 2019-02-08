//subclass for the circle shape
public class Circle extends Shape{
	
	private double radius;
	
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	
	public double getArea() {
		return (this.radius * this.radius * 3.1415926535);
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getRadius() {
		return this.radius;
	}

}
