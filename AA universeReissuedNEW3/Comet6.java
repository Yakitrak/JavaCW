import java.awt.Color;
import java.util.Random;
/**
 * Class Comet6 - A type of comet. Changes size if its hits an edge and changes lifetime whilst moving.
 * 
 * @author UP781587
 * @version 2016.03.13
 */
public class Comet6 extends Comet
{
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
    
    public Comet6(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, Universe theUniverse) 
   {
        super(xPos, yPos, xVel, yVel, objectDiameter, objectColor, theUniverse);
   }
    
   /**
   * Object size is changed to a random size when hitting an edge. Working from abstract method in Comet.
   */
   public void changeEdge(){
        Random rand = new Random();
        int randSize = rand.nextInt(20)+10;
        diameter = randSize;
   }
   
   /**
   * Object lifetime is reduced randomly while moving. Working from abstract method in Comet.
   */
   public void changeMove() {
        Random rand = new Random();
        int randLife = rand.nextInt(100000-50000+1)+50000;
        lifeTime -= randLife;
        System.out.println(this + " life time has been reduced to " + lifeTime);
   }
}
