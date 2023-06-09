package bounce;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBorderShape {
    private MockPainter painter;

    /**
     * This method is called automatically by the JUnit test-runner immediately
     * before each @Test method is executed. setUp() recreates the fixture so
     * that there no side effects from running individual tests.
     */
    @Before
    public void setUp() {
        painter = new MockPainter();
    }

    /**
     * Test to perform a simple (non-bouncing) movement, and to ensure that a
     * border Shape's position after the movement is correct.
     * Test if the given paddingNums equals the BorderShape's border numbers
     */
    @Test
    public void testSimpleMoveAndPaddingNums() {
        BorderShape borderShape = new BorderShape(new OvalShape(40, 50, 2, 3, 20, 30)
                , 3);
        borderShape.paint(painter);
        borderShape.move(500, 500);
        borderShape.paint(painter);
        assertEquals("(oval 40,50,20,30)(rectangle 38,48,24,34)(rectangle 36,46,28,38)(rectangle 34,44,32,42)" +
                        "(oval 42,53,20,30)(rectangle 40,51,24,34)(rectangle 38,49,28,38)(rectangle 36,47,32,42)",
                painter.toString());

        //check the specified padding numbers equals the shape's border numbers
        assertEquals(borderShape.getPaddingNum(), borderShape.getBorderRects().size());
    }

    /**
     * Test to perform a bounce off left walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffLeft() {
        BorderShape borderShape = new BorderShape(new OvalShape(8, 50, -5, 3, 20, 30));
        borderShape.paint(painter);
        borderShape.move(500, 500);
        borderShape.paint(painter);
        borderShape.move(500, 500);
        borderShape.paint(painter);
        assertEquals("(oval 8,50,20,30)(rectangle 6,48,24,34)(rectangle 4,46,28,38)" +
                        "(oval 4,53,20,30)(rectangle 2,51,24,34)(rectangle 0,49,28,38)" +
                        "(oval 9,56,20,30)(rectangle 7,54,24,34)(rectangle 5,52,28,38)",
                painter.toString());
    }


    /**
     * Test to perform a bounce off bottom walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffBottom() {
        BorderShape borderShape = new BorderShape(new OvalShape(20, 100, 5, 8, 20, 30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 20,100,20,30)(rectangle 18,98,24,34)(rectangle 16,96,28,38)" +
                        "(oval 25,86,20,30)(rectangle 23,84,24,34)(rectangle 21,82,28,38)" +
                        "(oval 30,78,20,30)(rectangle 28,76,24,34)(rectangle 26,74,28,38)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off top walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffTop() {
        BorderShape borderShape = new BorderShape(new OvalShape(20, 6, 5, -5, 20, 30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 20,6,20,30)(rectangle 18,4,24,34)(rectangle 16,2,28,38)" +
                        "(oval 25,4,20,30)(rectangle 23,2,24,34)(rectangle 21,0,28,38)" +
                        "(oval 30,9,20,30)(rectangle 28,7,24,34)(rectangle 26,5,28,38)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off right walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffRight() {
        BorderShape borderShape = new BorderShape(new OvalShape(100, 90, 5, 6, 20, 30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 100,90,20,30)(rectangle 98,88,24,34)(rectangle 96,86,28,38)" +
                        "(oval 96,86,20,30)(rectangle 94,84,24,34)(rectangle 92,82,28,38)" +
                        "(oval 91,80,20,30)(rectangle 89,78,24,34)(rectangle 87,76,28,38)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off top and right walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffTopAndRight() {
        BorderShape borderShape = new BorderShape(new OvalShape(95, 8, 6, -5, 20, 30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 95,8,20,30)(rectangle 93,6,24,34)(rectangle 91,4,28,38)" +
                        "(oval 96,4,20,30)(rectangle 94,2,24,34)(rectangle 92,0,28,38)" +
                        "(oval 90,9,20,30)(rectangle 88,7,24,34)(rectangle 86,5,28,38)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off top and left walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffTopAndLeft() {
        BorderShape borderShape = new BorderShape(new OvalShape(8, 4, -5, -5, 20, 30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 8,4,20,30)(rectangle 6,2,24,34)(rectangle 4,0,28,38)" +
                        "(oval 4,4,20,30)(rectangle 2,2,24,34)(rectangle 0,0,28,38)" +
                        "(oval 9,9,20,30)(rectangle 7,7,24,34)(rectangle 5,5,28,38)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off bottom and left walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffBottomAndLeft() {
        BorderShape borderShape = new BorderShape(new OvalShape(8, 100, -5, 5, 20, 30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 8,100,20,30)(rectangle 6,98,24,34)(rectangle 4,96,28,38)" +
                        "(oval 4,86,20,30)(rectangle 2,84,24,34)(rectangle 0,82,28,38)" +
                        "(oval 9,81,20,30)(rectangle 7,79,24,34)(rectangle 5,77,28,38)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off bottom and left walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffBottomAndRight() {
        BorderShape borderShape = new BorderShape(new OvalShape(100, 100, 5, 5, 20, 30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 100,100,20,30)(rectangle 98,98,24,34)(rectangle 96,96,28,38)" +
                        "(oval 96,86,20,30)(rectangle 94,84,24,34)(rectangle 92,82,28,38)" +
                        "(oval 91,81,20,30)(rectangle 89,79,24,34)(rectangle 87,77,28,38)",
                painter.toString());
    }

}
