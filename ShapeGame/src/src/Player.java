//class to define a player
public class Player extends Circle implements Movable, Scalable{

	public Player(double x, double y, double radius) {
		super(x, y, radius);
	}

	//movable methods
	//Override
	public void moveUp() {
		this.setY(this.getY() - 5);
	}
	//Override
	public void moveDown() {
		this.setY(this.getY() + 5);
	}
	//Override
	public void moveLeft() {
		this.setX(this.getX() - 5);
	}
	//Override
	public void moveRight() {
		this.setX(this.getX() + 5);
	}

	//scalable methods
	//Override
	public void grow() {
		this.setRadius(this.getRadius() + 10);
	}
	//Override
	public void shrink() {
		this.setRadius(this.getRadius() - 1);
	}
	
}
