

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Comet6Test.
 *
 * @author  UP781587
 * @version 14/03/2016
 */
public class Comet6Test
{
    /**
     * Default constructor for test class Comet6Test
     */
    public Comet6Test()
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
     * Tests if comets are colliding against walls
     */
    @Test
    public void bounce()
    {
        Universe universe1 = new Universe();
        Comet6 comet61 = new Comet6(490, 400, 10, 0, 20, java.awt.Color.BLUE, universe1);
        comet61.move();
        comet61.changeMove();
        comet61.move();
        comet61.move();
        comet61.move();
        comet61.move();
        comet61.move();
        comet61.move();
        assertEquals(560, comet61.getXPosition());
        assertEquals(400, comet61.getYPosition());
        assertEquals(20, comet61.getDiameter());
        comet61.move();
        comet61.move();
        comet61.move();
        comet61.move();
        assertEquals(-10, comet61.getXSpeed());
        assertEquals(400, comet61.getYPosition());
        assertEquals(28, comet61.getDiameter());
    }
}

