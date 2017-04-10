

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Comet7Test.
 *
 * @author  UP781587
 * @version 14/03/2016
 */
public class Comet7Test
{
    /**
     * Default constructor for test class Comet7Test
     */
    public Comet7Test()
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
     * Tests the same type comet collisions - Checks psoitions
     */
    @Test
    public void cometCollide()
    {
        Universe universe1 = new Universe();
        Comet7 comet71 = new Comet7(300, 300, 5, 0, 25, java.awt.Color.BLUE, universe1);
        Comet7 comet72 = new Comet7(350, 300, -5, 0, 25, java.awt.Color.BLUE, universe1);
        universe1.addArray(comet71);
        universe1.addArray(comet72);
        comet71.move();
        comet72.move();
        comet71.move();
        comet72.move();
        comet71.move();
        assertEquals(315, comet71.getXPosition()); //before collision
        assertEquals(300, comet71.getYPosition()); //before collision
        comet71.move();
        comet71.cometCollide();
        comet72.move();
        comet72.move();
        comet72.move();
        comet72.move();
        comet71.cometCollide();
        comet71.changeMove();
        comet72.move();
        comet71.move();
        comet71.move();
        comet71.move();
        comet72.move();
        assertEquals(305, comet71.getXPosition()); //after collision
        assertEquals(300, comet71.getYPosition()); //after collision
    }
}

