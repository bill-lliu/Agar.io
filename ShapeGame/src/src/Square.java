//subclass for Square
public class Square extends Shape{

	private double height;
	private double width;
	
	public Square(double x, double y, double height, double width) {
		super(x, y);
		this.height = height;
		this.width = width;
	}
	
	//other functions
	public double getArea() {
		return this.height*this.width;
	}
	public void setArea(double area) {
		this.height = Math.sqrt(area);
		this.width = Math.sqrt(area);
	}
	public double getHeight() {
		return this.height;
	}
	public double getWidth() {
		return this.width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setWidth(double width) {
		this.width = width;
	}

}
