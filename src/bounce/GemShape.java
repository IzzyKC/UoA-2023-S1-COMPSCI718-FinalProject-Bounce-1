package bounce;

public class GemShape extends Shape {
    /**
     * Default constructor that creates a GemShape instance whose instance
     * variables are set to default values.
     */
    public GemShape() {
        super();
    }

    /**
     * Creates a GemShape instance with specified values for instance
     * variables.
     *
     * @param x      x position.
     * @param y      y position.
     * @param deltaX speed and direction for horizontal axis.
     * @param deltaY speed and direction for vertical axis.
     */
    public GemShape(int x, int y, int deltaX, int deltaY) {
        super(x, y, deltaX, deltaY);
    }

    /**
     * Creates a GemShape instance with specified values for instance
     * variables.
     *
     * @param x      x position.
     * @param y      y position.
     * @param deltaX speed (pixels per move call) and direction for horizontal
     *               axis.
     * @param deltaY speed (pixels per move call) and direction for vertical
     *               axis.
     * @param width  width in pixels.
     * @param height height in pixels.
     */
    public GemShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);
    }

    @Override
    public void paint(Painter painter) {
        painter.drawGemShape(x, y, width, height);
    }
}