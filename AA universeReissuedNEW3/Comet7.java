import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

/**
 * Class Comet7 - A type of comet. Changes speed if its hits an edge and changes colour whilst moving.
 * 
 * @author UP781587
 * @version 2016.03.13
 */
public class Comet7 extends Comet
{
    private ArrayList<Color> colorList; //List of Colours that comets can be
    
     /**
     * Constructor for objects of class BlackHole
     *
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param xVel  the horizontal speed of the object
     * @param yVel  the vertical speed of the object
     * @param objectDiameter  the diameter (in pixels) of the object
     * @param objectColor  the color of the object
     * @param theUniverse  the universe this object is in
     */
    
    public Comet7(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, Universe theUniverse) 
    {
    super(xPos, yPos, xVel, yVel, objectDiameter, objectColor, theUniverse);
    colorList = new ArrayList<Color>();
    colorList.add(Color.red);
    colorList.add(Color.blue);
    colorList.add(Color.green);
    colorList.add(Color.cyan);
    colorList.add(Color.pink);
    colorList.add(Color.gray);
    
    }
    
     /**
     * Object speed is changed to a randomm speed when hitting an edge. Work from abstract method in Comet class.
     */
    public void changeEdge() 
    {
        Random rand = new Random();
        int randMultiplier = 0;
        while (randMultiplier == 0) { // ensures multiplier is not negative
        randMultiplier = rand.nextInt(2)+2;
        }

        int randYSpeed = ySpeed * randMultiplier;
        int randXSpeed = xSpeed * randMultiplier;
        
        if (randYSpeed >= 8 || randXSpeed >= 8) { //makes sure speed isnt too high
            randYSpeed/=3;
            randXSpeed/=3;
           
        }
        
        if (randYSpeed <= -8 || randXSpeed <= -8) { //makes sure speed isnt too high
            randYSpeed/=3; 
            randXSpeed/=3;
           
        }
         

        xSpeed = randXSpeed;
        ySpeed = randYSpeed;
    }
    
    /**
     * Object colour is changed to a random colour whilst moving. Working from abstract method in Comet.
     */
    public void changeMove() 
    {
       Random rand = new Random();
       int randColorIndex = rand.nextInt(6);
       Color newCol = colorList.get(randColorIndex); //Gets colour from the array using random colour
       color = newCol;
    }
}
