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
        GemShape regular = new GemShape(65, 20, 12, 15, 60, 30);
        regular.paint(painter);
        regular.move(135, 10000);
        regular.paint(painter);
        regular.move(135, 10000);
        regular.paint(painter);
        assertEquals("{regular (65,35),(85,20),(105,20),(125,35),(105,50),(85,50),60,30}"
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
        GemShape small = new GemShape(100, 100, 12, 15, 20, 30);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        assertEquals("{small (100,115),(110,100),(120,115),(110,130),20,30}"
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
     * Test to perform a bounce movement off the bottom left corner and to
     * ensure that the small gem Shape's position after the movement is correct.
     */
    @Test
    public void testSmallShapeMoveWithBounceOffBottomAndLeft() {
        GemShape small = new GemShape(10, 100, -12, 15, 20, 30);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        assertEquals("{small (10,115),(20,100),(30,115),(20,130),20,30}"
                + "{small (0,120),(10,105),(20,120),(10,135),20,30}"
                + "{small (12,105),(22,90),(32,105),(22,120),20,30}", painter.toString());
    }
    /**
     * Test to perform a bounce movement off the bottom left corner and to
     * ensure that the small gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularShapeMoveWithBounceOffBottomAndLeft() {
        GemShape small = new GemShape(10, 100, -12, 15, 60, 30);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        assertEquals("{regular (10,115),(30,100),(50,100),(70,115),(50,130),(30,130),60,30}" +
                "{regular (0,120),(20,105),(40,105),(60,120),(40,135),(20,135),60,30}" +
                "{regular (12,105),(32,90),(52,90),(72,105),(52,120),(32,120),60,30}", painter.toString());
    }


    /**
     * Test to perform a bounce movement off the top left corner and to
     * ensure that the small gem Shape's position after the movement is correct.
     */
    @Test
    public void testSmallShapeMoveWithBounceOffTopAndLeft() {
        GemShape small = new GemShape(10, 10, -12, -15, 20, 30);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        assertEquals("{small (10,25),(20,10),(30,25),(20,40),20,30}"
                + "{small (0,15),(10,0),(20,15),(10,30),20,30}"
                + "{small (12,30),(22,15),(32,30),(22,45),20,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the top left corner and to
     * ensure that the regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularShapeMoveWithBounceOffTopAndLeft() {
        GemShape regular = new GemShape(10, 10, -12, -15, 60, 30);
        regular.paint(painter);
        regular.move(125, 135);
        regular.paint(painter);
        regular.move(125, 135);
        regular.paint(painter);
        assertEquals("{regular (10,25),(30,10),(50,10),(70,25),(50,40),(30,40),60,30}"
                + "{regular (0,15),(20,0),(40,0),(60,15),(40,30),(20,30),60,30}"
                + "{regular (12,30),(32,15),(52,15),(72,30),(52,45),(32,45),60,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the top right corner and to
     * ensure that the small gem Shape's position after the movement is correct.
     */
    @Test
    public void testSmallShapeMoveWithBounceOffTopAndRight() {
        GemShape small = new GemShape(100, 10, 12, -15, 20, 30);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        small.move(125, 135);
        small.paint(painter);
        assertEquals("{small (100,25),(110,10),(120,25),(110,40),20,30}" +
                "{small (105,15),(115,0),(125,15),(115,30),20,30}" +
                "{small (93,30),(103,15),(113,30),(103,45),20,30}", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the top right corner and to
     * ensure that the regular gem Shape's position after the movement is correct.
     */
    @Test
    public void testRegularShapeMoveWithBounceOffTopAndRight() {
        GemShape regular = new GemShape(60, 10, 12, -15, 60, 30);
        regular.paint(painter);
        regular.move(125, 135);
        regular.paint(painter);
        regular.move(125, 135);
        regular.paint(painter);
        assertEquals("{regular (60,25),(80,10),(100,10),(120,25),(100,40),(80,40),60,30}" +
                "{regular (65,15),(85,0),(105,0),(125,15),(105,30),(85,30),60,30}" +
                "{regular (53,30),(73,15),(93,15),(113,30),(93,45),(73,45),60,30}", painter.toString());
    }

}
