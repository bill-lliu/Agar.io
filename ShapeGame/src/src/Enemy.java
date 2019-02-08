//class to define an enemy object
public class Enemy extends Square implements Movable{

	public Enemy(double x, double y, double height, double width) {
		super(x, y, height, width);
	}

	//movable methods
	//Override
	public void moveUp() {
		this.setY(this.getY() - 3);
	}
	//Override
	public void moveDown() {
		this.setY(this.getY() + 3);
	}
	//Override
	public void moveLeft() {
		this.setX(this.getX() - 3);
	}
	//Override
	public void moveRight() {
		this.setX(this.getX() + 3);
	}

}
