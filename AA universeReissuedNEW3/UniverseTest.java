

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UniverseTest.
 *
 * @author  UP781587
 * @version 14/03/2016
 */
public class UniverseTest
{
    /**
     * Default constructor for test class UniverseTest
     */
    public UniverseTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    
     /**
     * Checks if orbit positions are working as intended. Gets X and Y Poosition
     */
    @Test
    public void orbit()
    {
        Universe universe1 = new Universe();
        Star star1 = new Star(250, 250, 0, 0, 50, java.awt.Color.YELLOW, universe1);
        Planet planet1 = new Planet(290, 290, 4, 4, 250, 250, 200, 20, java.awt.Color.RED, universe1);
        star1.move();
        planet1.move();
        assertEquals(306, planet1.getXPosition());
        assertEquals(250, planet1.getYPosition());
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        planet1.move();
        assertEquals(303, planet1.getXPosition());
        assertEquals(267, planet1.getYPosition());
    }
}


