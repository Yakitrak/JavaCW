

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StarTest.
 *
 * @author  UP781587
 * @version 14/03/2016
 */
public class StarTest
{
    /**
     * Default constructor for test class StarTest
     */
    public StarTest()
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
     */
    @After
    public void tearDown()
    {
    }
    

    /**
     * Checks the life time of the object after colliding.
     */
    @Test
    public void lifetimeTester()
    {
        Universe universe1 = new Universe();
        Star star1 = new Star(300, 300, 0, 0, 50, java.awt.Color.YELLOW, universe1);
        Comet7 comet71 = new Comet7(250, 300, 5, 0, 25, java.awt.Color.BLUE, universe1);
        star1.move();
        comet71.move();
        universe1.addArray(star1);
        universe1.addArray(comet71);
        comet71.move();
        comet71.move();
        comet71.move();
        assertEquals(1, comet71.getLifeTime());
        assertEquals(1000066, star1.getLifeTime());
    }
}

