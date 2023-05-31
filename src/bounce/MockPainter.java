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

    /**
     * Logs the drawGemShape call.
     */
    public void drawGemShape(int x, int y, int width, int height) {
        String midLeft = "(" + x + "," + (y + height / 2) + ")";
        String midRight = "(" + (x + width) + "," + (y + height / 2) + ")";
        if (width < 40) {
            String top = "(" + (x + width / 2) + "," + y + ")";
            String bottom = "(" + (x + width / 2) + "," + (y + height) + ")";
            log.append("{small " + top + "," + midLeft + "," + midRight + "," + bottom +
                    "," + width + "," + height + "}");
        } else {
            String topLeft = "(" + (x + 20) + "," + y + ")";
            String topRight = "(" + (x + width - 20) + "," + y + ")";
            String bottomLeft= "(" + (x + 20) + "," + (y+height) + ")";
            String bottomRight = "(" + (x + width - 20) + "," + (y+height) + ")";
            log.append("{regular " + topLeft + "," + topRight + ","+ midLeft + ","+ midRight +
                    ","+ bottomLeft + ","+ bottomRight + "," + width + "," + height + "}");
        }
    }
}