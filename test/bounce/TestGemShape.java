package bounce;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGemShape {
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
     * small gem Shape's position after the movement is correct.
     */
    @Test
    public void testSmallGemShapeSimpleMove() {
        GemShape small = new GemShape(100, 20, 12, 15,30,40);
        small.paint(painter);
        small.move(500, 500);
        small.paint(painter);
        assertEquals("{small (115,20),(100,40),(130,40),(115,60),30,40}"+
                        "{small (127,35),(112,55),(142,55),(127,75),30,40}",
                painter.toString());
    }

    /**
     * Test to perform a simple (non-bouncing) movement, and to ensure that a
     * regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularGemShapeSimpleMove() {
        GemShape regular = new GemShape(100, 20, 12, 15,80,60);
        regular.paint(painter);
        regular.move(500, 500);
        regular.paint(painter);
        assertEquals("{regular (120,20),(160,20),(100,50),(180,50),(120,80),(160,80),80,60}"+
                        "{regular (132,35),(172,35),(112,65),(192,65),(132,95),(172,95),80,60}",
                painter.toString());
    }

    /**
     * Test to perform a bounce movement off the right-most boundary and to
     * ensure that the small gem Shape's position after the movement is correct.
     */
    @Test
    public void testSmallGemShapeMoveWithBounceOffRight() {
        GemShape small = new GemShape(100, 20, 12, 15,20,30);
        small.paint(painter);
        small.move(135, 10000);
        small.paint(painter);
        small.move(135, 10000);
        small.paint(painter);
        assertEquals("{small (110,20),(100,35),(120,35),(110,50),20,30}"
                + "{small (122,35),(112,50),(132,50),(122,65),20,30}"
                + "{small (125,50),(115,65),(135,65),(125,80),20,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the right-most boundary and to
     * ensure that the regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularGemShapeMoveWithBounceOffRight() {
        GemShape regular = new GemShape(100, 20, 12, 15,60,30);
        regular.paint(painter);
        regular.move(135, 10000);
        regular.paint(painter);
        regular.move(135, 10000);
        regular.paint(painter);
        assertEquals("{regular (120,20),(140,20),(100,35),(160,35),(120,50),(140,50),60,30}"
                + "{regular (95,35),(115,35),(75,50),(135,50),(95,65),(115,65),60,30}"
                + "{regular (83,50),(103,50),(63,65),(123,65),(83,80),(103,80),60,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the left-most boundary and to
     * ensure that the small gem Shape's position after the movement is correct.
     */
    @Test
    public void testSmallGemShapeMoveWithBounceOffLeft() {
        GemShape small = new GemShape(100, 20, -12, 15,20,30);
        small.paint(painter);
        small.move(10000, 10000);
        small.paint(painter);
        small.move(10000, 10000);
        small.paint(painter);
        assertEquals("{small (110,20),(100,35),(120,35),(110,50),20,30}"
                + "{small (98,35),(88,50),(108,50),(98,65),20,30}"
                + "{small (86,50),(76,65),(96,65),(86,80),20,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the left-most boundary and to
     * ensure that the regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularGemShapeMoveWithBounceOffLeft() {
        GemShape regular = new GemShape(100, 20, -12, 15,60,30);
        regular.paint(painter);
        regular.move(10000, 10000);
        regular.paint(painter);
        regular.move(10000, 10000);
        regular.paint(painter);
        assertEquals("{regular (120,20),(140,20),(100,35),(160,35),(120,50),(140,50),60,30}"
                + "{regular (108,35),(128,35),(88,50),(148,50),(108,65),(128,65),60,30}"
                + "{regular (96,50),(116,50),(76,65),(136,65),(96,80),(116,80),60,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the small gem Shape's position after the movement is correct.
     */
    @Test
    public void testSmallShapeMoveWithBounceOffBottomAndRight() {
        GemShape small = new GemShape(100, 20, 12, 15,20,30);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        assertEquals("{small (110,20),(100,35),(120,35),(110,50),20,30}"
                + "{small (115,35),(105,50),(125,50),(115,65),20,30}"
                + "{small (103,50),(93,65),(113,65),(103,80),20,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularShapeMoveWithBounceOffBottomAndRight() {
        GemShape regular = new GemShape(100, 20, 12, 15,60,30);
        regular.paint(painter);
        regular.move(125, 135);
        regular.paint(painter);
        regular.move(125, 135);
        regular.paint(painter);
        assertEquals("{regular (120,20),(140,20),(100,35),(160,35),(120,50),(140,50),60,30}"
                + "{regular (85,35),(105,35),(65,50),(125,50),(85,65),(105,65),60,30}"
                + "{regular (73,50),(93,50),(53,65),(113,65),(73,80),(93,80),60,30}", painter.toString());
    }

}
