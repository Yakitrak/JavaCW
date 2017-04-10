import java.awt.*;


/**
 * Class Space_Object - an object that exists in a finite Universe. Space objects can be comets, stars, planets or black holes. Working in inheritance as a superclass.
 * 
 * Movement can be initiated by repeated calls to the "move" method.
 *  
 * @author Robert Topp & UP781587
 *
 * @version 2016.03.13
 */

abstract class Space_Object
{
    protected Color color;
    protected int diameter;
    protected int xPosition;
    protected int yPosition;
    protected final int groundPosition; // y position of the bottom of the Universe
    protected final int topPosition; // y positionof the top of the universe
    protected final int leftPosition; // x positionof the left of the universe
    protected final int rightPosition; // x positionof the right of the universe
    protected Universe universe;
    protected int xSpeed; // current horizontal speed   (+  moving left to right, - right to left
    protected int ySpeed; // current vertical speed ( + moving down, - moving up)
    protected int lifeTime; // lifetime of the object

    /**
     * Constructor for objects of class Space_Object
     *
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param xVel  the horizontal speed of the object
     * @param yVel  the vertical speed of the object
     * @param objectDiameter  the diameter (in pixels) of the object
     * @param objectColor  the color of the object
     * @param theUniverse  the universe this object is in
     */
    public Space_Object(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, Universe theUniverse)
    {
        xPosition = xPos;
        yPosition = yPos;
        xSpeed = xVel;
        ySpeed = yVel;
        color = objectColor;
        diameter = objectDiameter;
        universe = theUniverse;
        groundPosition = universe.getBottomEdge();
        topPosition = universe.getTopEdge();
        leftPosition = universe.getLeftEdge();
        rightPosition = universe.getRightEdge();
        
        lifeTime = 1000000;
        
    }

   
    /**
     * Move this object according to its position and speed and redraw. Will call the appropriate move methods in subclasses
     **/
    abstract void move();
   

    /**
     * return the horizontal position of this object
     */
    public int getXPosition()
    {
        return xPosition;
    }
    
    
    public void setXPosition(int positionValue)
    {
        xPosition = positionValue;
    }
    
    public void setYPosition(int positionValue)
    {
        yPosition = positionValue;
    }

    /**
     * return the vertical position of this object
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    /**
     * return the colour of this object
    */
    public Color getColor()
    {
        return color;
    }
    
    /**
     * Sets the colour of the object
     *
     * @param colourValue  the new colour of the object
     */
    public void setColor(Color colourValue)
    {
        color = colourValue;
    }
    
    /**
     * return the xSpeed of this object
    */
    public int getXSpeed()
    {
        return xSpeed;
    }
    
     /**
     * Sets the xSpeed of the object
     *
     * @param speedValue  the new speed of the object
     */
    public void setXSpeed(int speedValue)
    {
        xSpeed = speedValue;
    }
    
    /**
     * return the ySpeed of this object
    */   
    public int getYSpeed()
    {
        return ySpeed;
    }
    
    /**
     * Sets the ySpeed of the object
     *
     * @param speedValue  the new speed of the object
     */
    public void setYSpeed(int speedValue)
    {
        ySpeed = speedValue;
    }
    
    /**
     * sets the diameter of this object
     */
    public void setDiameter(int diameterValue)
    {
        diameter = diameterValue;
    }
    
     /**
     * return the diameter of this object
     */
    public int getDiameter()
    {
        return diameter;
    }
    
    /**
    * return the radius of this object
    */
    public int getRadius()
    {
        return diameter/2;
    }
    
    /**
    * return the universe
    */
    public Universe getUniverse() 
    {
     return universe;
    }
    
    /**
    * return the life time of the object
    */
    public int getLifeTime() 
    {
     return lifeTime;
    }
    
     /**
     * Sets the lifetime of the object
     *
     * @param lifeTimeValue  the new life time of the object
     */
    public void setLifeTime(int lifeTimeValue) 
    {
     lifeTime -= lifeTimeValue;
    }
    
    /**
    * check the lifetime of the object. If lifetime is not 0, it decreases the lifetime
    */
    public void checkLife()
    {
        if (getLifeTime() <= 0) {
            universe.addDelArray(this);
            System.out.println(this + " has been destroyed because lifetime is 0");
            
        } else {
            lifeTime--;
        }
        
    }      
}

