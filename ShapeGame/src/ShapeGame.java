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
  
//Keyboard imports
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//Util
import java.util.ArrayList;


class ShapeGame extends JFrame { 

  //class variables
  static JFrame window;
  JPanel gamePanel;
   
  
   //Main
   public static void main(String[] args) {
     window = new ShapeGame(); 
     
     Player player = new Player();//creates the player
     
     ArrayList<Class> myArray = new ArrayList ArrayList<Class>;//creates array list of enemies
     
     
     
     
     
     
     
     
     
     
   }
   
  
  //Constructor - this runs first
  ShapeGame() { 
    super("My Game");  
    
    //create enemies and player

    
    
    
    //spawn 5 enemies

    
    
    
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
       
       
       //check for collision
       
       
       
       
       
       //draw all squares
       
       g.fillRect(50,50,100,100);
       
       
       //draw player circle
       g.setColor(Color.BLUE);
       g.fillOval(200,200,20,20); 
       
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
       
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")) {  //If 'D' is pressed
  
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {  //If ESC is pressed
          System.out.println("Quitting!"); //close frame & quit
          window.dispose();
  
        } 
      }   
      
      public void keyReleased(KeyEvent e) {
      }
    } //end of keyboard listener
  
 
    
}