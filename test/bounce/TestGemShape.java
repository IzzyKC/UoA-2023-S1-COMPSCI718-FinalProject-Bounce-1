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
        GemShape small = new GemShape(100, 20, 12, 15, 30, 40);
        small.paint(painter);
        small.move(500, 500);
        small.paint(painter);
        assertEquals("{small (100,40),(115,20),(130,40),(115,60),30,40}" +
                        "{small (112,55),(127,35),(142,55),(127,75),30,40}",
                painter.toString());
    }

    /**
     * Test to perform a simple (non-bouncing) movement, and to ensure that a
     * regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularGemShapeSimpleMove() {
        GemShape regular = new GemShape(100, 20, 12, 15, 80, 60);
        regular.paint(painter);
        regular.move(500, 500);
        regular.paint(painter);
        assertEquals("{regular (100,50),(120,20),(160,20),(180,50),(160,80),(120,80),80,60}" +
                        "{regular (112,65),(132,35),(172,35),(192,65),(172,95),(132,95),80,60}",
                painter.toString());
    }

    /**
     * Test to perform a bounce movement off the right-most boundary and to
     * ensure that the small gem Shape's position after the movement is correct.
     */
    @Test
    public void testSmallGemShapeMoveWithBounceOffRight() {
        GemShape small = new GemShape(100, 20, 12, 15, 20, 30);
        small.paint(painter);
        small.move(135, 10000);
        small.paint(painter);
        small.move(135, 10000);
        small.paint(painter);
        assertEquals("{small (100,35),(110,20),(120,35),(110,50),20,30}"
                + "{small (112,50),(122,35),(132,50),(122,65),20,30}"
                + "{small (115,65),(125,50),(135,65),(125,80),20,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the right-most boundary and to
     * ensure that the regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularGemShapeMoveWithBounceOffRight() {
        GemShape regular = new GemShape(100, 20, 12, 15, 60, 30);
        regular.paint(painter);
        regular.move(135, 10000);
        regular.paint(painter);
        regular.move(135, 10000);
        regular.paint(painter);
        assertEquals("{regular (100,35),(120,20),(140,20),(160,35),(140,50),(120,50),60,30}"
                + "{regular (75,50),(95,35),(115,35),(135,50),(115,65),(95,65),60,30}"
                + "{regular (63,65),(83,50),(103,50),(123,65),(103,80),(83,80),60,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the left-most boundary and to
     * ensure that the small gem Shape's position after the movement is correct.
     */
    @Test
    public void testSmallGemShapeMoveWithBounceOffLeft() {
        GemShape small = new GemShape(100, 20, -12, 15, 20, 30);
        small.paint(painter);
        small.move(10000, 10000);
        small.paint(painter);
        small.move(10000, 10000);
        small.paint(painter);
        assertEquals("{small (100,35),(110,20),(120,35),(110,50),20,30}"
                + "{small (88,50),(98,35),(108,50),(98,65),20,30}"
                + "{small (76,65),(86,50),(96,65),(86,80),20,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the left-most boundary and to
     * ensure that the regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularGemShapeMoveWithBounceOffLeft() {
        GemShape regular = new GemShape(100, 20, -12, 15, 60, 30);
        regular.paint(painter);
        regular.move(10000, 10000);
        regular.paint(painter);
        regular.move(10000, 10000);
        regular.paint(painter);
        assertEquals("{regular (100,35),(120,20),(140,20),(160,35),(140,50),(120,50),60,30}"
                + "{regular (88,50),(108,35),(128,35),(148,50),(128,65),(108,65),60,30}"
                + "{regular (76,65),(96,50),(116,50),(136,65),(116,80),(96,80),60,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the small gem Shape's position after the movement is correct.
     */
    @Test
    public void testSmallShapeMoveWithBounceOffBottomAndRight() {
        GemShape small = new GemShape(100, 20, 12, 15, 20, 30);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        assertEquals("{small (100,35),(110,20),(120,35),(110,50),20,30}"
                + "{small (105,50),(115,35),(125,50),(115,65),20,30}"
                + "{small (93,65),(103,50),(113,65),(103,80),20,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularShapeMoveWithBounceOffBottomAndRight() {
        GemShape regular = new GemShape(100, 20, 12, 15, 60, 30);
        regular.paint(painter);
        regular.move(125, 135);
        regular.paint(painter);
        regular.move(125, 135);
        regular.paint(painter);
        assertEquals("{regular (100,35),(120,20),(140,20),(160,35),(140,50),(120,50),60,30}"
                + "{regular (65,50),(85,35),(105,35),(125,50),(105,65),(85,65),60,30}"
                + "{regular (53,65),(73,50),(93,50),(113,65),(93,80),(73,80),60,30}", painter.toString());
    }

}
