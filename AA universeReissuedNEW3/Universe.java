import java.awt.Color;
import java.util.ArrayList;

/**
 * Class Universe - a universe which contains comets, stars, planets and black holes.
 *
 * @author Robert Topp & UP781587
 * @version 2016.03.13
 */

public class Universe  
{
    private ArrayList<Space_Object> spaceList; //Storing all space objects currently on canvas
    private ArrayList<Space_Object> delList; //Storing objects which need to be deleted
    private Canvas universe; 
    private int leftEdge = 0; 
    private int topEdge = 0;
    private int rightEdge;
    private int bottomEdge;

    /**
     * Create a universe with default name and size. Creates a fresh canvas to display the universe
     */
    public Universe()
    {
        universe = new Canvas("Universe Demo", 600, 500);
        rightEdge = 600;
        bottomEdge = 500;
        spaceList = new ArrayList<Space_Object>();
        delList = new ArrayList<Space_Object>();
    }
    /**
     *  Create a universe with given name and size
     *  @param name The name to give the universe
     *  @param rightEdge The maximum x coordinate
     *  @param bottomEdge The maximum y coordinate
     */
     public Universe(String name, int rightEdge, int bottomEdge)
    {
        universe = new Canvas(name, rightEdge, bottomEdge);
        this.rightEdge = rightEdge;
        this.bottomEdge = bottomEdge;
        spaceList = new ArrayList<Space_Object>();
        delList = new ArrayList<Space_Object>();
    }
    
    /**
     * Erase an object from the view of the universe
     * 
     * @param spaceObj The object to be erased
     */
    public void erase(Space_Object spaceObj)
    {
        universe.eraseCircle(spaceObj.getXPosition() - spaceObj.getRadius(), spaceObj.getYPosition()- spaceObj.getRadius(), spaceObj.getDiameter());
    }
    
     /**
     * Draw an object at its current position onto the view of the universe.
     * 
     * @param spaceObj The object to be drawn
     */
    public void draw(Space_Object spaceObj)
    {
        universe.setForegroundColor(spaceObj.getColor());
        universe.fillCircle(spaceObj.getXPosition() - spaceObj.getRadius(), spaceObj.getYPosition() - spaceObj.getRadius(), spaceObj.getDiameter());
    }
    
    /**
     * Return the y cordinate of the bottom of the universe
     */
    public int getBottomEdge()
    {
        return bottomEdge;
    }
    
    /**
     * Return the y cordinate of the top of the universe
     */
    public int getTopEdge()
    {
        return topEdge;
    }
    
    /**
     * Return the x cordinate of the left of the universe
     */
    public int getLeftEdge()
    {
        return leftEdge;
    }
    
    /**
     * Return the x cordinate of the right of the universe
     */
    public int getRightEdge()
    {
        return rightEdge;
    }
    
    /**
     * Return the list of space objects currently in the universe
     */
    public ArrayList<Space_Object> getSpaceList()
    {
        return spaceList;
    }
    
    /**
     * Adds objects to spaceList array
     * @parem object object to be added to array
     */
    public void addArray(Space_Object object) 
    {
        spaceList.add(object);
    }
    
    /**
     * Return the list of space objects to be deleted
     */
    public ArrayList<Space_Object> getdelList()
    {
        return delList;
    }
   
    /**
     * Add an object to delList so it can be deleted
     * 
     * @param newDel The object to be added in the deletion array
     */
    public void addDelArray(Space_Object newDel)
    {
        delList.add(newDel);
    }
    
     /**
     * Demo which includes all objects in the universe
     */
    public void demoAll()
    {
        spaceList.add(new Comet6(500, 500, -2, -2, 25, Color.GREEN, this));
        spaceList.add(new Comet6(5, 5, 2, 2, 20, Color.GREEN, this));
        
        spaceList.add(new Comet7(200, 200, 2, 2, 13, Color.BLUE, this));
        spaceList.add(new Comet7(400, 20, 2, 2, 20, Color.BLUE, this));
        
        spaceList.add(new Star(400, 300, 0, 0, 60, Color.YELLOW, this));
        spaceList.add(new Star(200, 100, 0, 0, 70, Color.YELLOW, this));
        
        spaceList.add(new Planet(430, 380, 0, 0, 400, 300, 350, 10, Color.ORANGE, this));
        spaceList.add(new Planet(380, 250, 0, 0, 400, 300, -200, 8, Color.ORANGE, this));
        spaceList.add(new Planet(190, 160, 0, 0, 200, 100, 200, 12, Color.ORANGE, this));
        
        spaceList.add(new BlackHole(350, 100, 0, 0, 40, Color.BLACK, this));
        run();
    }
    
    /**
     * Demo which includes only comet type 6 - Shows wall and same comet collision
     */
    public void demoComet6()
    {
        spaceList.add(new Comet6(400, 400, 2, 2, 25, Color.GREEN, this));
        spaceList.add(new Comet6(200, 200, -2, -2, 20, Color.GREEN, this));
        spaceList.add(new Comet6(50, 100, -4, -4, 25, Color.GREEN, this));
        spaceList.add(new Comet6(350, 150, 3, 3, 30, Color.GREEN, this));
        
        run();
    }
    
    
    /**
     * Demo which includes only comet type 7 - Shows wall and same comet collision
     */
    public void demoComet7()
    {
        spaceList.add(new Comet7(300, 40, 2, 2, 25, Color.BLUE, this));
        spaceList.add(new Comet7(240, 400, -2, -2, 20, Color.BLUE, this));
        spaceList.add(new Comet7(10, 300, -4, -4, 25, Color.BLUE, this));
        spaceList.add(new Comet7(30, 100, 3, 3, 30, Color.BLUE, this));
        
        run();
    }
    
    
     /**
     * Demo which includes comet type 6 & 7 - Shows different comet collision - part 1
     */
    public void demoDifferentComet()
    {
        spaceList.add(new Comet6(200, 200, 2, 2, 20, Color.GREEN, this));
        spaceList.add(new Comet6(400, 400, -2, -2, 25, Color.GREEN, this));
        
        spaceList.add(new Comet7(100,100, -3, -3, 20, Color.BLUE, this));
        run();
    }
    
    /**
     * Demo which includes comet type 6 & 7 - Shows different comet collision - part 2
     */
    public void demoDifferentComet2()
    {
        spaceList.add(new Comet6(100, 100, 2, 2, 20, Color.GREEN, this));
     
        spaceList.add(new Comet7(400,400, -2, -2, 20, Color.BLUE, this));
        run();
    }
    
     /**
     * Demo which includes comet type 6 & 7 - Shows different comet collision
     */
    public void demoStarPlanetCollide()
    {       
        spaceList.add(new Comet7(400, 250, 2, 1, 20, Color.BLUE, this));
        spaceList.add(new Comet7(200, 246, 2, 1, 32, Color.BLUE, this));
        
        spaceList.add(new Star(400, 300, 0, 0, 60, Color.YELLOW, this));
        spaceList.add(new Star(200, 100, 0, 0, 70, Color.YELLOW, this));
        
        spaceList.add(new Planet(430, 380, 0, 0, 400, 300, 350, 10, Color.ORANGE, this));
        spaceList.add(new Planet(380, 250, 0, 0, 400, 300, -200, 8, Color.ORANGE, this));
        spaceList.add(new Planet(190, 160, 0, 0, 200, 100, 200, 12, Color.ORANGE, this));
        run();
    }
    
    /**
     * Demo which shows comets getting pulled into a black hole
     */
    public void demoBlackHole()
    {
        spaceList.add(new Comet6(200, 200, -3, -4, 25, Color.GREEN, this));
        spaceList.add(new Comet6(400, 300, -3, -3, 20, Color.GREEN, this));
        
        spaceList.add(new Comet7(10, 10, -2, -2, 13, Color.BLUE, this));
        spaceList.add(new Comet7(90, 90, 2, 3, 20, Color.BLUE, this));
       
        spaceList.add(new BlackHole(250, 250, 0, 0, 40, Color.BLACK, this));
        
        run();
    }
    
    /**
     * Goes through the spaceList array drawing / moving each object and checking its life. 
     * 
     * Goes through the delList array deleting all the objects in the list.
     */
    public void run()
    {
        boolean finished =  false;
        while(!finished) {  
            universe.wait(50);         
            for (Space_Object object : spaceList ) 
            {           
               object.move();
               object.checkLife();
            }
            

            for (Space_Object del : delList) {
                 erase(del);
                 spaceList.remove(del);
                 
            }  
            delList.clear();
           
        }
    }
}
