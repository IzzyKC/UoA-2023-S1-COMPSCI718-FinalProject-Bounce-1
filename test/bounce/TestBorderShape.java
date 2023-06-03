package bounce;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
     */
    @Test
    public void testSimpleMove() {
        BorderShape borderShape = new BorderShape(new OvalShape(40,50,2,3,20,30));
        borderShape.paint(painter);
        borderShape.move(500, 500);
        borderShape.paint(painter);
        assertEquals("(oval 40,50,20,30)(rectangle 38,48,24,34)(rectangle 36,46,28,38)"+
                        "(oval 42,53,20,30)(rectangle 40,51,24,34)(rectangle 38,49,28,38)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off left walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffLeft() {
        BorderShape borderShape = new BorderShape(new OvalShape(20,50,-5,3,20,30));
        borderShape.paint(painter);
        borderShape.move(500, 500);
        borderShape.paint(painter);
        borderShape.move(500, 500);
        borderShape.paint(painter);
        assertEquals("(oval 20,50,20,30)(rectangle 18,48,24,34)(rectangle 16,46,28,38)"+
                        "(oval 15,53,20,30)(rectangle 13,51,24,34)(rectangle 11,49,28,38)"+
                        "(oval 20,58,20,30)(rectangle 18,56,24,34)(rectangle 16,54,28,38)",
                painter.toString());
    }


    /**
     * Test to perform a bounce off bottom walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffBottom() {
        BorderShape borderShape = new BorderShape(new OvalShape(20,90,5,8,20,30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 20,90,20,30)(rectangle 18,88,24,34)(rectangle 16,86,28,38)"+
                        "(oval 25,90,20,30)(rectangle 23,88,24,34)(rectangle 21,86,28,38)"+
                        "(oval 30,90,20,30)(rectangle 28,88,24,34)(rectangle 26,86,28,38)",
                painter.toString());
    }
    /**
     * Test to perform a bounce off top walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffTop() {
        BorderShape borderShape = new BorderShape(new OvalShape(20,40,5,-5,20,30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 20,40,20,30)(rectangle 18,38,24,34)(rectangle 16,36,28,38)"+
                        "(oval 25,35,20,30)(rectangle 23,33,24,34)(rectangle 21,31,28,38)"+
                        "(oval 30,40,20,30)(rectangle 28,38,24,34)(rectangle 26,36,28,38)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off right walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffRight() {
        BorderShape borderShape = new BorderShape(new OvalShape(20,90,5,6,20,30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 20,90,20,30)(rectangle 18,88,24,34)(rectangle 16,86,28,38)"+
                        "(oval 25,90,20,30)(rectangle 23,88,24,34)(rectangle 21,86,28,38)"+
                        "(oval 30,90,20,30)(rectangle 28,88,24,34)(rectangle 26,86,28,38)",
                painter.toString());
    }
    /**
     * Test to perform a bounce off top and right walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffTopAndRight() {
        BorderShape borderShape = new BorderShape(new OvalShape(95,40,5,-5,20,30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 95,40,20,30)(rectangle 93,38,24,34)(rectangle 91,36,28,38)"+
                        "(oval 100,35,20,30)(rectangle 98,33,24,34)(rectangle 96,31,28,38)"+
                        "(oval 100,40,20,30)(rectangle 98,38,24,34)(rectangle 96,36,28,38)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off top and left walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffTopAndLeft() {
        BorderShape borderShape = new BorderShape(new OvalShape(25,40,-5,-5,20,30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 25,40,20,30)(rectangle 23,38,24,34)(rectangle 21,36,28,38)"+
                        "(oval 20,35,20,30)(rectangle 18,33,24,34)(rectangle 16,31,28,38)"+
                        "(oval 25,40,20,30)(rectangle 23,38,24,34)(rectangle 21,36,28,38)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off bottom and left walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffBottomAndLeft() {
        BorderShape borderShape = new BorderShape(new OvalShape(20,95,-5,5,20,30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 20,95,20,30)(rectangle 18,93,24,34)(rectangle 16,91,28,38)"+
                        "(oval 15,90,20,30)(rectangle 13,88,24,34)(rectangle 11,86,28,38)"+
                        "(oval 20,90,20,30)(rectangle 18,88,24,34)(rectangle 16,86,28,38)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off bottom and left walls and none of the borders should
     * pass beyond the world’s boundaries
     */
    @Test
    public void testBorderShapeMoveBounceOffBottomAndRight() {
        BorderShape borderShape = new BorderShape(new OvalShape(20,95,-5,5,20,30));
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        borderShape.move(120, 120);
        borderShape.paint(painter);
        assertEquals("(oval 20,95,20,30)(rectangle 18,93,24,34)(rectangle 16,91,28,38)"+
                        "(oval 15,90,20,30)(rectangle 13,88,24,34)(rectangle 11,86,28,38)"+
                        "(oval 20,90,20,30)(rectangle 18,88,24,34)(rectangle 16,86,28,38)",
                painter.toString());
    }

}
