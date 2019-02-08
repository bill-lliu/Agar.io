/* February 6, 2019
 * Bill
 * ShapeGame.java
 * main method for game
 */

/**
* This template can be used as reference or a starting point for the Shape Game
* for your final summative project
* @author Mangat
**/

//Graphics &GUI imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;
//Keyboard imports
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//Util
import java.util.ArrayList;


class ShapeGame extends JFrame { 

  //class variables
  static JFrame window;
  JPanel gamePanel;
  Player player;
  ArrayList<Enemy> enemies;
   
  
   //Main
   public static void main(String[] args) {
     window = new ShapeGame(); 
     
     
     
     
     
     
     
     
   }
   
  
  //Constructor - this runs first
  ShapeGame() { 
    super("My Game");  
    
    //create enemies and player
    player = new Player(300, 100, 20);//creates the player
    enemies = new ArrayList<Enemy>();//creates array list of enemies
    
    
    //spawn 5 enemies
    for (int i=1; i<6; i++) {
   	 Enemy square = new Enemy(250*i, 150*i, 5, 5);
   	 enemies.add(square);
    }	
    
    
    // Set the frame to full screen 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
   // this.setUndecorated(true);  //Set to true to remove title bar
   //frame.setResizable(false);


    
    //Set up the game panel (where we put our graphics)
    gamePanel = new GameAreaPanel();
    this.add(new GameAreaPanel());
    
    MyKeyListener keyListener = new MyKeyListener();
    this.addKeyListener(keyListener);

    this.requestFocusInWindow(); //make sure the frame has focus   
    
    this.setVisible(true);
  

   
  } //End of Constructor


  
  /** --------- INNER CLASSES ------------- **/
  
  // Inner class for the the game area - This is where all the drawing of the screen occurs
  private class GameAreaPanel extends JPanel {
    public void paintComponent(Graphics g) {   
       super.paintComponent(g); //required
       setDoubleBuffered(true); 

       //move enemies
       for (int i=0; i<enemies.size(); i++) {
    	   int tmp = (int)(Math.random()*4) + 1;
    	   if (tmp == 1) {
        	   enemies.get(i).moveUp();
    	   } else if (tmp == 2) {
        	   enemies.get(i).moveDown();
    	   } else if (tmp == 3) {
        	   enemies.get(i).moveLeft();    		   
    	   } else if (tmp == 4) {
        	   enemies.get(i).moveRight();
    	   }
       }
       
       //spawns new enemies
       for (int i=0; i<enemies.size(); i++) {
    	   int tmp = (int)(Math.random()*7500) + 1;
    	   if (tmp == 1) {
	    	   int tmp2 = (int)(Math.random()*5) + 1;
	    	   Enemy square = new Enemy(250*tmp2, 150*tmp2, 5, 5);
	    	   enemies.add(square);
    	   }
       }
       
       //check for collision
       for (int i=0; i<enemies.size(); i++) {
    	   if ((enemies.get(i).getX() + enemies.get(i).getWidth()) >= player.getX()
    			   && enemies.get(i).getX() <= (player.getX() + player.getRadius())
    			   && (enemies.get(i).getY() + enemies.get(i).getHeight()) >= player.getY()
    			   && enemies.get(i).getY() <= (player.getY() + player.getRadius())) {
    		   System.out.println("intersection!");
        	   enemies.remove(i);
        	   player.grow();
    	   }
       }
       
       
	//draw all squares
       g.setColor(Color.RED);
       for (int i=0; i<enemies.size(); i++) {
    	   g.fillRect((int)enemies.get(i).getX(),(int)enemies.get(i).getY(),(int)enemies.get(i).getWidth(),(int)enemies.get(i).getHeight());
       }
       
       
       //draw player circle
       g.setColor(Color.BLUE);
       g.fillOval((int)player.getX(),(int)player.getY(),(int)player.getRadius(),(int)player.getRadius()); 
       
       //repaint
       repaint();
    }
  }
  
  // -----------  Inner class for the keyboard listener - this detects key presses and runs the corresponding code
    private class MyKeyListener implements KeyListener {
  
      public void keyTyped(KeyEvent e) {  
      }

      public void keyPressed(KeyEvent e) {
        //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
       
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("W")) {  //If 'W' is pressed
        	player.moveUp();
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")) { // if 'A' is pressed
        	player.moveLeft();
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("S")) { // if 'S' is pressed
        	player.moveDown();
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")) { // if 'D' is pressed
        	player.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {  //If ESC is pressed
          System.out.println("Quitting!"); //close frame & quit
          window.dispose();
  
        } 
      }   
      
      public void keyReleased(KeyEvent e) {
      }
    } //end of keyboard listener
  
 
    
}