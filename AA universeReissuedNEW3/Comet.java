import java.util.ArrayList;
import java.awt.*;
import java.util.Random;
import java.lang.Math;

/**
 * Class Comet - Space objects that bounce againsts walls. Have collisions with all other objects. Destroyed if it hits a star or planet. Sucked in by black holes.
 * Can be two types, comet6 and comet7 which are subclasses of this superclass.  
 *
 * @author UP781587
 * @version 2016.03.13
 */
 abstract class Comet extends Space_Object
 {
    private int time = 1000; // time for timetick method
    private int radius = diameter/2; // computes radius of the comet        
    private boolean attract = false; // checks if black hole has a comet in range
    
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
    public Comet(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, Universe theUniverse) 
    {     
        super(xPos, yPos, xVel, yVel, objectDiameter, objectColor, theUniverse);    
    }
    
    /**
     * Abstract method from Space_Object. Moves in straight lines, checking for wall collisions.
     */
    public void move()
    {
        universe.erase(this);
        
        yPosition += ySpeed; 
        xPosition += xSpeed;
        // compute new position
        
        timeTick(); // checks for lifetime
        
        // check if it has hit the ground
        if(yPosition >= (groundPosition - radius) && ySpeed > 0) {
          yPosition = groundPosition - radius;
          ySpeed = -ySpeed; 
          changeEdge();
        }
        
        // check if it has hit the top
        if(yPosition <= (topPosition + radius)  && ySpeed < 0){
          yPosition = topPosition + radius;
          ySpeed = -ySpeed; 
          changeEdge();
        }
        
        // check if it has hit the left
        if(xPosition <= (leftPosition + radius)){
            xPosition = leftPosition + radius;
            xSpeed = -xSpeed; 
            changeEdge();
        }
        
        // check if it has hit the right
        if(xPosition >= (rightPosition - radius) && xSpeed > 0) {
          xPosition = rightPosition - radius;
          xSpeed = -xSpeed; 
          changeEdge();
        }
         cometCollide(); //checks for comet collisions and black hole attraction
         universe.draw(this);
    }
    /**
     * Deducts a random amount of time from time to execute comet behaviour. If 0, it will reset it.
     */
    public void timeTick()
    {
     Random rand = new Random();
     int randTime = rand.nextInt(30);
     time-=randTime;
     
     if (time <= 0) { //if 0, the time is reset and comet behaviour is executed
         changeMove();
         time = 1000;
     }
    }
    
     /**
     * Abstract method required to call the appropriate changeEdge method in sub class comet 6 and 7.
     */
    abstract void changeEdge();
    
     /**
     * Abstract method required to call the appropriate changeMove method in sub class comet 6 and 7.
     */    
    abstract void changeMove();
    
     /**
     * Checks for collisions between comets and all space objects. Includes comet to comet, star and planet collisions. Also BlackHole attraction.
     */
    public void cometCollide() 
    { 
      for (Space_Object object : universe.getSpaceList()) //loops through the array of space objects
       {
        int distance = calcDist(this.xPosition, this.yPosition, object.xPosition, object.yPosition); 
        int totalRad = this.radius + object.diameter / 2; 
          if(object instanceof Star) //checking if object is star
          {
            if(distance <= totalRad) { //checking if colliding
               double planArea =  Math.PI * Math.pow(diameter/2, 2);
               double starArea = Math.PI * Math.pow(this.radius, 2);
               double totArea = planArea + starArea;
               int newArea = (int) (2* Math.sqrt(totArea / Math.PI));
               object.lifeTime += newArea; //increasing lifetime
               System.out.println("Comet has hit a star and increased its life time to " + object.lifeTime + " by " + (int)(starArea));
               universe.addDelArray(this); 
          }
        } 
          
        if(object instanceof Planet) //checking of object is planet
          {
            if(distance <= totalRad) { //checking if colliding
               double planArea =  Math.PI * Math.pow(diameter/2, 2);
               double comArea = Math.PI * Math.pow(this.radius, 2);
               double totArea = planArea + comArea;
               int newArea = (int) (2* Math.sqrt(totArea / Math.PI));
               object.diameter = newArea; //increase size by area
               System.out.println("Comet has hit a planet and increased its size to " + newArea);
               universe.addDelArray(this);
            }
        }
          
        if((object instanceof Comet6 && this instanceof Comet6) || (object instanceof Comet7 && this instanceof Comet7)) //checking for same comet objects
          {
            if(distance <= totalRad) { //checking if colliding
              //reversing both comet speeds
              this.xSpeed = -xSpeed;
              this.ySpeed = -ySpeed;
              object.xSpeed = -xSpeed;
              object.ySpeed = -ySpeed;
              
            }
        }
          
          if((object instanceof Comet6 && this instanceof Comet7) || (object instanceof Comet7 && this instanceof Comet6)) //checking for different comet objects
          {
            if(distance <= totalRad) { //checking if colliding
              if (object.diameter > this.diameter) { //comparing size
               universe.addDelArray(this); 
               System.out.println("2 Different comets have collided. The smaller one has been destroyed");
              }
              else if (object.diameter < this.diameter) { //comparing size
               universe.addDelArray(object);
               System.out.println("2 Different comets have collided. The smaller one has been destroyed");
              }
              
              else if (object.diameter == this.diameter) { //checking if size is equal
                  if (calcSpeed(object.ySpeed, object.xSpeed) > calcSpeed(this.ySpeed, this.xSpeed)) { //comparing speed
                  universe.addDelArray(this);
                  System.out.println("2 Different comets have collided. The size is equal so the slower one has been destroyed");
                  }
                  
                  else if (calcSpeed(object.ySpeed, object.xSpeed) < calcSpeed(this.ySpeed, this.xSpeed)) { //comparing speed
                  universe.addDelArray(object);
                  System.out.println("2 Different comets have collided. The size is equal so the slower one has been destroyed");
                  }
                  
                  else if (calcSpeed(object.ySpeed, object.xSpeed) == calcSpeed(this.ySpeed, this.xSpeed)) { //checking if speed is equal
                   universe.addDelArray(this);
                   universe.addDelArray(object);
                   System.out.println("2 Different comets have collided. The size and speed are equal so both have been destroyed");
                  }    
            }
          }
        }
        if (object instanceof BlackHole) { // checking if object is black hole
            if (distance < 110)  { //checking if object is in range
               if (!attract) { //checking if object is being pulled by black hole
                    attract = true;
                    this.xSpeed = ((object.xPosition) - this.xPosition) /8;
                    this.ySpeed = ((object.yPosition) - this.yPosition) /8;
                    System.out.println("A comet is in range of black hole and being pulled in");
               }
               System.out.println("xSpeed: " + xSpeed); 
               System.out.println("ySpeed: " + ySpeed); 

               this.xSpeed*=1.1; //speeding up as it gets closer to black hole
               this.ySpeed*=1.1; //speeding up as it gets closer to black hole
                 
               if (distance <= totalRad) { //checking if it has collided with the black hole
                   universe.addDelArray(this); 
                   System.out.println("A comet has been completely pulled into the black hole");
               }
            }
        }
      }     
     
    }
    
    /**
     * Calculates the distance between 2 points given 
     * @param x1 x position of the first object
     * @parem y1 y position of the first object
     * @parem x2 x position of the second object
     * @parem y2 x positiono f the second object
     */
    public int calcDist(int x1, int y1, int x2, int y2) 
    {
        double xd = Math.pow((x2 - x1), 2);
        double yd = Math.pow((y2 - y1), 2);
        int dist = (int) (Math.sqrt(xd + yd));
        return dist;
    }
    
     /**
     * Calculates the speed of an object (for comparing purposes)
     * @param x xspeed of the objct
     * @parem y yspeed of the object
     */
    public int calcSpeed(int x, int y)
    {
        int nx = Math.abs(x);
        int ny = Math.abs(y);
        int tspeed = nx + ny;
        return tspeed;
    }
    

}
