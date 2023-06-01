package bounce;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOvalShape {
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
     * Shape's position after the movement is correct.
     */
    @Test
    public void testSimpleMove() {
        OvalShape shape = new OvalShape(100, 20, 12, 15);
        shape.paint(painter);
        shape.move(500, 500);
        shape.paint(painter);
        assertEquals("(oval 100,20,25,35)(oval 112,35,25,35)",
                painter.toString());
    }
    /**
     * Test to perform a bounce movement off the right-most boundary and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffRight() {
        RectangleShape shape = new RectangleShape(100, 20, 12, 0);
        shape.paint(painter);
        shape.move(135, 10000);
        shape.paint(painter);
        shape.move(135, 10000);
        shape.paint(painter);
        assertEquals("(rectangle 100,20,25,35)(rectangle 110,20,25,35)"
                + "(rectangle 98,20,25,35)", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the left-most boundary and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffLeft() {
        RectangleShape shape = new RectangleShape(100, 20, -12, 0);
        shape.paint(painter);
        shape.move(135, 10000);
        shape.paint(painter);
        shape.move(135, 10000);
        shape.paint(painter);
        assertEquals("(rectangle 100,20,25,35)(rectangle 88,20,25,35)"
                + "(rectangle 76,20,25,35)", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the top-most boundary and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffTop() {
        RectangleShape shape = new RectangleShape(20, 75, 0, -15);
        shape.paint(painter);
        shape.move(100, 120);
        shape.paint(painter);
        shape.move(100, 120);
        shape.paint(painter);
        assertEquals("(rectangle 20,75,25,35)(rectangle 20,60,25,35)"
                + "(rectangle 20,45,25,35)", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the Bottom-most boundary and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffBottom() {
        RectangleShape shape = new RectangleShape(20, 60, 0, 15);
        shape.paint(painter);
        shape.move(100, 120);
        shape.paint(painter);
        shape.move(100, 120);
        shape.paint(painter);
        assertEquals("(rectangle 20,60,25,35)(rectangle 20,75,25,35)"
                + "(rectangle 20,85,25,35)", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the top right corner boundary and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffTopAndRight() {
        OvalShape shape = new OvalShape(100, 20, 12, -15);
        shape.paint(painter);
        shape.move(135, 10000);
        shape.paint(painter);
        shape.move(135, 10000);
        shape.paint(painter);
        assertEquals("(oval 100,20,25,35)(oval 110,5,25,35)"
                + "(oval 98,0,25,35)", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the top left corner and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffTopAndLeft() {
        OvalShape shape = new OvalShape(10, 20, -12, -15);
        shape.paint(painter);
        shape.move(10000, 10000);
        shape.paint(painter);
        shape.move(10000, 10000);
        shape.paint(painter);
        assertEquals("(oval 10,20,25,35)(oval 0,5,25,35)"
                + "(oval 12,0,25,35)", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffBottomAndRight() {
        OvalShape shape = new OvalShape(90, 90, 12, 15);
        shape.paint(painter);
        shape.move(125, 135);
        shape.paint(painter);
        shape.move(125, 135);
        shape.paint(painter);
        assertEquals("(oval 90,90,25,35)(oval 100,100,25,35)"
                + "(oval 88,85,25,35)", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom left corner and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffBottomAndLeft() {
        OvalShape shape = new OvalShape(90, 90, -12, 15);
        shape.paint(painter);
        shape.move(125, 135);
        shape.paint(painter);
        shape.move(125, 135);
        shape.paint(painter);
        assertEquals("(oval 90,90,25,35)(oval 78,100,25,35)"
                + "(oval 66,85,25,35)", painter.toString());
    }
}
