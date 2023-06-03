package bounce;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestDynamicRectangleShape {
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
     * Test to perform a bounce off Left walls and changes its appearance to solid figure
     * then bounces off top walls and renders itself with an outline
     */
    @Test
    public void testBounceOffLeftThenTop() {
        DynamicRectangleShape shape = new DynamicRectangleShape(10, 20, -12, -15,
                10, 20, Color.RED);
        shape.paint(painter);
        shape.move(130, 90);
        shape.paint(painter);
        shape.move(130, 90);
        shape.paint(painter);
        assertEquals("(rectangle 10,20,10,20)(filled rectangle 0,5,10,20)(rectangle 12,0,10,20)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off right walls and changes its appearance to solid figure
     * then bounces off top walls and renders itself with an outline
     */
    @Test
    public void testBounceOffRightThenTop() {
        DynamicRectangleShape shape = new DynamicRectangleShape(125, 20, 12, -15,
                10, 20, Color.RED);
        shape.paint(painter);
        shape.move(130, 60);
        shape.paint(painter);
        shape.move(130, 60);
        shape.paint(painter);
        assertEquals("(rectangle 125,20,10,20)(filled rectangle 120,5,10,20)(rectangle 108,0,10,20)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off Left walls and changes its appearance to solid figure
     * then bounces off bottom walls and renders itself with an outline
     */
    @Test
    public void testBounceOffLeftThenBottom() {
        DynamicRectangleShape shape = new DynamicRectangleShape(10, 15, -12, 15,
                10, 20, Color.RED);
        shape.paint(painter);
        shape.move(130, 60);
        shape.paint(painter);
        shape.move(130, 60);
        shape.paint(painter);
        assertEquals("(rectangle 10,15,10,20)(filled rectangle 0,30,10,20)(rectangle 12,40,10,20)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off right walls and changes its appearance to solid figure
     * then bounces off top walls and renders itself with an outline
     */
    @Test
    public void testBounceOffRightThenBottom() {
        DynamicRectangleShape shape = new DynamicRectangleShape(125, 20, 12, 15,
                10, 20, Color.RED);
        shape.paint(painter);
        shape.move(130, 60);
        shape.paint(painter);
        shape.move(130, 60);
        shape.paint(painter);
        assertEquals("(rectangle 125,20,10,20)(filled rectangle 120,35,10,20)(rectangle 108,40,10,20)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off bottom walls and renders itself with an outline
     * then bounces off left walls and changes its appearance to solid figure
     */
    @Test
    public void testBounceOffBottomThenLeft() {
        DynamicRectangleShape shape = new DynamicRectangleShape(20, 20, -12, 15,
                10, 20, Color.RED);
        shape.paint(painter);
        shape.move(120, 60);
        shape.paint(painter);
        shape.move(120, 60);
        shape.paint(painter);
        assertEquals("(rectangle 20,20,10,20)(rectangle 8,35,10,20)(filled rectangle 0,40,10,20)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off bottom walls and renders itself with an outline
     * then bounces off right walls and changes its appearance to solid figure
     */
    @Test
    public void testBounceOffBottomThenRight() {
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 40, 12, 10,
                10, 30, Color.RED);
        shape.paint(painter);
        shape.move(130, 60);
        shape.paint(painter);
        shape.move(130, 60);
        shape.paint(painter);
        assertEquals("(rectangle 100,40,10,30)(rectangle 112,30,10,30)(filled rectangle 120,20,10,30)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off top walls and renders itself with an outline
     * then bounces off left walls and changes its appearance to solid figure
     */
    @Test
    public void testBounceOffTopThenLeft() {
        DynamicRectangleShape shape = new DynamicRectangleShape(20, 20, -12, -20,
                10, 30, Color.RED);
        shape.paint(painter);
        shape.move(130, 60);
        shape.paint(painter);
        shape.move(130, 60);
        shape.paint(painter);
        assertEquals("(rectangle 20,20,10,30)(rectangle 8,0,10,30)(filled rectangle 0,20,10,30)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off top walls and renders itself with an outline
     * then bounces off right walls and changes its appearance to solid figure
     */
    @Test
    public void testBounceOffTopThenRight() {
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, 12, -20,
                10, 30, Color.RED);
        shape.paint(painter);
        shape.move(130, 60);
        shape.paint(painter);
        shape.move(130, 60);
        shape.paint(painter);
        assertEquals("(rectangle 100,20,10,30)(rectangle 112,0,10,30)(filled rectangle 120,20,10,30)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off top and right walls at same time
     * and changes its appearance to solid figure
     */
    @Test
    public void testBounceOffTopAndRight() {
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, 12, -20,
                10, 30, Color.RED);
        shape.paint(painter);
        shape.move(120, 40);
        shape.paint(painter);
        assertEquals("(rectangle 100,20,10,30)(filled rectangle 110,0,10,30)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off top and right walls at same time
     * and changes its appearance to solid figure
     */
    @Test
    public void testBounceOffTopAndLeft() {
        DynamicRectangleShape shape = new DynamicRectangleShape(10, 20, -12, -20,
                10, 30, Color.RED);
        shape.paint(painter);
        shape.move(120, 40);
        shape.paint(painter);
        assertEquals("(rectangle 10,20,10,30)(filled rectangle 0,0,10,30)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off bottom and left walls at same time
     * and changes its appearance to solid figure
     */
    @Test
    public void testBounceOffBottomAndLeft() {
        DynamicRectangleShape shape = new DynamicRectangleShape(10, 20, -12, 20,
                10, 30, Color.RED);
        shape.paint(painter);
        shape.move(120, 40);
        shape.paint(painter);
        assertEquals("(rectangle 10,20,10,30)(filled rectangle 0,10,10,30)",
                painter.toString());
    }

    /**
     * Test to perform a bounce off bottom and right walls at same time
     * and changes its appearance to solid figure
     */
    @Test
    public void testBounceOffBottomAndRight() {
        DynamicRectangleShape shape = new DynamicRectangleShape(115, 20, 12, 20,
                10, 30, Color.RED);
        shape.paint(painter);
        shape.move(120, 40);
        shape.paint(painter);
        assertEquals("(rectangle 115,20,10,30)(filled rectangle 110,10,10,30)",
                painter.toString());
    }

}
