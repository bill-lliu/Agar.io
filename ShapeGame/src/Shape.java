//Shape Superclass

import java.awt.Rectangle;

public abstract class Shape {
	private double x;
	private double y;
	private Rectangle boundingBox;
	
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract double getArea();
	
	public Rectangle getBoundingBox() {
		return this.boundingBox;
	}
	public void setX(double newX) {
		this.x = newX;
	}
	public void setY(double newY) {
		this.y = newY;
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
}
