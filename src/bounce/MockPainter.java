package bounce;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging simply logging them. The contents of a MockPainter object's
 * log can be retrieved by a call to toString() on the MockPainter.
 *
 * @author Ian Warren
 */
public class MockPainter implements Painter {
    // Internal log.
    private StringBuffer log = new StringBuffer();

    /**
     * Returns the contents of this MockPainter's log.
     */
    public String toString() {
        return log.toString();
    }

    /**
     * Logs the drawRect call.
     */
    public void drawRect(int x, int y, int width, int height) {
        log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
    }

    /**
     * Logs the drawOval call.
     */
    public void drawOval(int x, int y, int width, int height) {
        log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
    }
}