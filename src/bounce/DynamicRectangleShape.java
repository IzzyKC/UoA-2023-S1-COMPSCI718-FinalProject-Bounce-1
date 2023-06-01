package bounce;

import java.awt.*;

public class DynamicRectangleShape extends Shape {
    protected Color color;
    protected boolean isSolid;


    /**
     * Default constructor that creates a DynamicRectangleShape instance whose instance
     * variables are set to default values.
     */
    public DynamicRectangleShape() {
        super();
        this.color =DEFAULT_COLOR;
    }

    /**
     * Default constructor that creates a DynamicRectangleShape instance with a specific color
     */
    public DynamicRectangleShape(Color color) {
        super();
        this.color =color;
    }

    /**
     * Creates a Shape object with a specified x and y position.
     */
    public DynamicRectangleShape(int x, int y) {
        super(x,y);
        this.color = DEFAULT_COLOR;

    }

    /**
     * Creates a Shape object with a specified x ,y and color.
     */
    public DynamicRectangleShape(int x, int y, Color color) {
        super(x,y);
        this.color = color;
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
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY);
        this.color = DEFAULT_COLOR;
    }

    /**
     * Creates a GemShape instance with specified values for instance
     * variables.
     *
     * @param x      x position.
     * @param y      y position.
     * @param deltaX speed and direction for horizontal axis.
     * @param deltaY speed and direction for vertical axis.
     * @param color  shape color
     */
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, Color color) {
        super(x, y, deltaX, deltaY);
        this.color = color;
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
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);
        this.color = color;
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
     * @param color  shape color
     */
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
        super(x, y, deltaX, deltaY, width, height);
        this.color = color;
    }

    /**
     * Paints this DynamicRectangleShape object using the supplied Painter object.
     * DynamicRectangleShape changes its appearance when it bounces.
     */
    @Override
    public void paint(Painter painter) {
        painter.setColor(color);
        painter.drawDynamicRectangle(x, y, width, height, isSolid);
    }

    /**
     * Moves this Shape object within the specified bounds. On hitting a
     * boundary the Shape instance bounces off and back into the two-
     * dimensional world.
     * After it bounces off the left or right wall it paints itself as a solid figure, in the color
     * pecified at construction time.
     * After it bounces off the top or bottom wall it switches its
     * appearance to that of a RectangleShape, i.e. rendering itself with an outline.
     * If it bounces off both walls, the vertical (left or right) wall determines its appearance.
     *
     * @param width  width of two-dimensional world.
     * @param height height of two-dimensional world.
     */
    public void moveAndCheckBounceoff(int width, int height) {
        super.move(width, height);
        if (isCollision) {
            if (isBounceVertical)
                isSolid = true;
            else
                isSolid = false;
        }
    }
}
