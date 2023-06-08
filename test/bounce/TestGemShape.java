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
        GemShape small = new GemShape(110, 20, 12, 15, 20, 30);
        small.paint(painter);
        small.move(135, 10000);
        small.paint(painter);
        small.move(135, 10000);
        small.paint(painter);
        assertEquals("{small (110,35),(120,20),(130,35),(120,50),20,30}"
                + "{small (115,50),(125,35),(135,50),(125,65),20,30}"
                + "{small (103,65),(113,50),(123,65),(113,80),20,30}", painter.toString());
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
        GemShape small = new GemShape(10, 20, -12, 15, 20, 30);
        small.paint(painter);
        small.move(10000, 10000);
        small.paint(painter);
        small.move(10000, 10000);
        small.paint(painter);
        assertEquals("{small (10,35),(20,20),(30,35),(20,50),20,30}"
                + "{small (0,50),(10,35),(20,50),(10,65),20,30}"
                + "{small (12,65),(22,50),(32,65),(22,80),20,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the left-most boundary and to
     * ensure that the regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularGemShapeMoveWithBounceOffLeft() {
        GemShape regular = new GemShape(10, 20, -12, 15, 60, 30);
        regular.paint(painter);
        regular.move(10000, 10000);
        regular.paint(painter);
        regular.move(10000, 10000);
        regular.paint(painter);
        assertEquals("{regular (10,35),(30,20),(50,20),(70,35),(50,50),(30,50),60,30}"
                + "{regular (0,50),(20,35),(40,35),(60,50),(40,65),(20,65),60,30}"
                + "{regular (12,65),(32,50),(52,50),(72,65),(52,80),(32,80),60,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the small gem Shape's position after the movement is correct.
     */
    @Test
    public void testSmallShapeMoveWithBounceOffBottomAndRight() {
        GemShape small = new GemShape(115, 120, 12, 15, 20, 30);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        assertEquals("{small (115,135),(125,120),(135,135),(125,150),20,30}"
                + "{small (105,120),(115,105),(125,120),(115,135),20,30}"
                + "{small (93,105),(103,90),(113,105),(103,120),20,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularShapeMoveWithBounceOffBottomAndRight() {
        GemShape regular = new GemShape(60, 100, 12, 15, 60, 30);
        regular.paint(painter);
        regular.move(125, 135);
        regular.paint(painter);
        regular.move(125, 135);
        regular.paint(painter);
        assertEquals("{regular (60,115),(80,100),(100,100),(120,115),(100,130),(80,130),60,30}"
                + "{regular (65,120),(85,105),(105,105),(125,120),(105,135),(85,135),60,30}"
                + "{regular (53,105),(73,90),(93,90),(113,105),(93,120),(73,120),60,30}", painter.toString());
    }
    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the small gem Shape's position after the movement is correct.
     */
    @Test
    public void testSmallShapeMoveWithBounceOffTopAndLeft() {
        GemShape small = new GemShape(10, 10, 12, 15, 20, 30);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        assertEquals("{small (10,25),(20,10),(30,25),(20,40),20,30}"
                + "{small (22,40),(32,25),(42,40),(32,55),20,30}"
                + "{small (34,55),(44,40),(54,55),(44,70),20,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularShapeMoveWithBounceOffTopAndLeft() {
        GemShape regular = new GemShape(10, 10, 12, 15, 60, 30);
        regular.paint(painter);
        regular.move(125, 135);
        regular.paint(painter);
        regular.move(125, 135);
        regular.paint(painter);
        assertEquals("{regular (10,25),(30,10),(50,10),(70,25),(50,40),(30,40),60,30}"
                + "{regular (22,40),(42,25),(62,25),(82,40),(62,55),(42,55),60,30}"
                + "{regular (34,55),(54,40),(74,40),(94,55),(74,70),(54,70),60,30}", painter.toString());
    }

}
