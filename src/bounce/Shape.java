package bounce;

import java.awt.*;

/**
 * Abstract superclass to represent the general concept of a Shape. This class
 * defines state common to all special kinds of Shape instances and implements
 * a common movement algorithm. Shape subclasses must override method paint()
 * to handle shape-specific painting.
 *
 * @author Ian Warren
 */
public abstract class Shape {
    // === Constants for default values. ===
    protected static final int DEFAULT_X_POS = 0;

    protected static final int DEFAULT_Y_POS = 0;

    protected static final int DEFAULT_DELTA_X = 5;

    protected static final int DEFAULT_DELTA_Y = 5;

    protected static final int DEFAULT_HEIGHT = 35;

    protected static final int DEFAULT_WIDTH = 25;

    protected static final Color DEFAULT_COLOR = Color.BLACK;
    // ===

    // === Instance variables, accessible by subclasses.
    protected int x;

    protected int y;

    protected int deltaX;

    protected int deltaY;

    protected int width;

    protected int height;
    protected boolean isCollision;

    //shape bounces off the left or right wall
    protected boolean isBounceVertical;

    //shape bounces off the top or bottom wall
    protected boolean isBounceHorizontal;

    // ===

    /**
     * Creates a Shape object with default values for instance variables.
     */
    public Shape() {
        this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    /**
     * Creates a Shape object with a specified x and y position.
     */
    public Shape(int x, int y) {
        this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    /**
     * Creates a Shape instance with specified x, y, deltaX and deltaY values.
     * The Shape object is created with a default width and height.
     */
    public Shape(int x, int y, int deltaX, int deltaY) {
        this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    /**
     * Creates a Shape instance with specified x, y, deltaX, deltaY, width,
     * height and color values.
     */
    public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
        this.x = x;
        this.y = y;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.width = width;
        this.height = height;
    }

    /**
     * Moves this Shape object within the specified bounds. On hitting a
     * boundary the Shape instance bounces off and back into the two-
     * dimensional world.
     *
     * @param width  width of two-dimensional world.
     * @param height height of two-dimensional world.
     */
    public void move(int width, int height) {
        isCollision = false;
        isBounceVertical = false;
        isBounceHorizontal = false;
        int nextX = x + deltaX;
        int nextY = y + deltaY;

        if (nextX <= 0) {
            nextX = 0;
            deltaX = -deltaX;
            isCollision = true;
            isBounceVertical = true;
        } else if (nextX + this.width >= width) {
            nextX = width - this.width;
            deltaX = -deltaX;
            isCollision = true;
            isBounceVertical = true;
        }

        if (nextY <= 0) {
            nextY = 0;
            deltaY = -deltaY;
            isCollision = true;
            isBounceHorizontal = true;
        } else if (nextY + this.height >= height) {
            nextY = height - this.height;
            deltaY = -deltaY;
            isCollision = true;
            isBounceHorizontal =true;
        }

        x = nextX;
        y = nextY;
    }

    /**
     * Method to be implemented by concrete subclasses to handle subclass
     * specific painting.
     *
     * @param painter the Painter object used for drawing.
     */
    public abstract void paint(Painter painter);

    /**
     * Returns this Shape object's x position.
     */
    public int x() {
        return x;
    }

    /**
     * Returns this Shape object's y position.
     */
    public int y() {
        return y;
    }

    /**
     * Returns this Shape object's speed and direction.
     */
    public int deltaX() {
        return deltaX;
    }

    /**
     * Returns this Shape object's speed and direction.
     */
    public int deltaY() {
        return deltaY;
    }

    /**
     * Returns this Shape's width.
     */
    public int width() {
        return width;
    }

    /**
     * Returns this Shape's height.
     */
    public int height() {
        return height;
    }

    /**
     * Returns a String whose value is the fully qualified name of this class
     * of object. E.g., when called on a RectangleShape instance, this method
     * will return "bounce.RectangleShape".
     */
    public String toString() {
        return getClass().getName();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isCollision() {
        return isCollision;
    }

    public boolean isBounceVertical() {
        return isBounceVertical;
    }

    public boolean isBounceHorizontal() {
        return isBounceHorizontal;
    }
}
