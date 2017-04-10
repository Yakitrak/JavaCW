

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BlackHoleTest.
 *
 * @author  UP781587
 * @version 14/03/2016
 */
public class BlackHoleTest
{
    /**
     * Default constructor for test class BlackHoleTest
     */
    public BlackHoleTest()
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
     *  Tests if speed is increased when going towards black hole, and if deleted upon impact
     */
    @Test
    public void gravitySpeed()
    {
        Universe universe2 = new Universe();
        BlackHole blackHol3 = new BlackHole(300, 300, 0, 0, 50, java.awt.Color.BLACK, universe2);
        Comet7 comet73 = new Comet7(250, 200, 8, 0, 30, java.awt.Color.BLUE, universe2);
        universe2.addArray(blackHol3);
        universe2.addArray(comet73);
        blackHol3.move();
        comet73.move();
        assertEquals(5, comet73.getXSpeed()); //speed before entering black hole range
        assertEquals(13, comet73.getYSpeed()); //speed before entering black hole range 
        comet73.move();
        comet73.move();
        comet73.move();
        assertEquals(5, comet73.getXSpeed()); //speed after entering black hole range
        assertEquals(16, comet73.getYSpeed()); //speed after entering black hole range - speed increase
        comet73.move();
        comet73.move();
        universe2.run(); //deleting the comet from the space list
    }
}

