import java.awt.Color;
/**
 * Class Star - Stationary space objects which are orbitted by planets. If a comet hits a star, it is destroyed and gives its lifetime to stars.
 * 
 * @author UP781587
 * @version 2016.03.13
 */
public class Star extends Space_Object
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
    public Star(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, Universe theUniverse) 
    {
    super(xPos, yPos, xVel, yVel, objectDiameter, objectColor, theUniverse);
    }
   
     /**
     * Simply redraws the star as it is suppose to be stationary. Working from abstract method in Space_Object.
     */
    public void move()
    {
    universe.erase(this);
    universe.draw(this);
    }
}
