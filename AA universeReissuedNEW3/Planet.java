import java.awt.Color;
import java.lang.Math;
/**
 * Class Planet - Space objects that orbit a star. If hit by a comet, it will destroy the comet and gain its size.
 * 
 * @author UP781587
 * @version 2016.03.13
 */
 public class Planet extends Space_Object
 {
     private double speed; //Speed of orbit
     private double distance; // distance from the star centre to planet centre
     private double angle; // defines the speed of the planet making it orbit
     private int originXPos; // xposition of the star
     private int originYPos; //yposition of the star
     
    
    /**
     * Constructor for objects of class Planet
     *
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param xVel  the horizontal speed of the object
     * @param yVel  the vertical speed of the object
     * @param starXPos the x position of the star
     * @param starYPos the y position of the star
     * @parem rotationSpeed the rotation direction and speed of the planet
     * @param objectDiameter  the diameter (in pixels) of the object
     * @param objectColor  the color of the object
     * @param theUniverse  the universe this object is in
     */
    public Planet(int xPos, int yPos, int xVel, int yVel, int starXPos, int starYPos, int rotationSpeed, int objectDiameter, Color objectColor, Universe theUniverse) 
    {     
        super(xPos, yPos, xVel, yVel, objectDiameter, objectColor, theUniverse); 
        distance = Math.sqrt(Math.pow((starYPos - yPosition), 2) + Math.pow((starXPos - xPosition), 2));
        speed = Math.PI/rotationSpeed;
        angle = 0;
        originXPos = starXPos;
        originYPos = starYPos;
        


    }
     /**
     * Moves / orbits the planet around the stars. Working from abstract method in Space_Object.
     */
    public void move() 
    {
        universe.erase(this);

         xPosition = (int)(originXPos + distance * Math.cos(angle));
         yPosition = (int)(originYPos + distance * Math.sin(angle));
         angle+=speed;
        
        universe.draw(this);
    }
}
