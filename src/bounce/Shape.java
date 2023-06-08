package bounce;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
    protected static final String DEFAULT_Text = "";
    // ===

    // === Instance variables, accessible by subclasses.
    protected int x;

    protected int y;

    protected int deltaX;

    protected int deltaY;

    protected int width;

    protected int height;

    //parent of NestingShape child
    protected NestingShape parent;

    //text
    protected String text;
    // ===

    /**
     * Creates a Shape object with default values for instance variables.
     */
    public Shape() {
        this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_Text);
    }

    public Shape(String text) {
        this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, text);
    }

    /**
     * Creates a Shape object with a specified x and y position.
     */
    public Shape(int x, int y) {
        this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_Text);
    }

    public Shape(int x, int y, String text) {
        this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, text);
    }

    /**
     * Creates a Shape instance with specified x, y, deltaX and deltaY values.
     * The Shape object is created with a default width and height.
     */
    public Shape(int x, int y, int deltaX, int deltaY) {
        this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_Text);
    }

    public Shape(int x, int y, int deltaX, int deltaY, String text) {
        this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT, text);
    }

    /**
     * Creates a Shape instance with specified x, y, deltaX, deltaY, width,
     * height and color values.
     */
    public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
        this(x, y, deltaX, deltaY, width, height, DEFAULT_Text);
    }

    public Shape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    /**
     * Moves this Shape object within the specified bounds. On hitting a
     * boundary the Shape instance bounces off and back into the two-dimensional world.
     * The priority of bounce off vetical walls is always higher than horizontal walls.
     * Thus check bounce off vertical walls later.
     *
     * @param width  width of two-dimensional world.
     * @param height height of two-dimensional world.
     */
    public void move(int width, int height) {
        int nextX = x + deltaX;
        int nextY = y + deltaY;

        if (nextY <= 0) {
            nextY = 0;
            deltaY = -deltaY;
        } else if (nextY + this.height >= height) {
            nextY = height - this.height;
            deltaY = -deltaY;
        }

        if (nextX <= 0) {
            nextX = 0;
            deltaX = -deltaX;
        } else if (nextX + this.width >= width) {
            nextX = width - this.width;
            deltaX = -deltaX;
        }

        x = nextX;
        y = nextY;
    }

    /**
     * Method to be implemented by concrete subclasses to handle subclass
     * specific painting.
     * This is a hook method of draw(Template method)
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

    /**
     * sets this Shape's deltaX.
     */
    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    /**
     * sets this Shape's deltaY
     */
    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    /**
     * sets this Shape's x position.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * sets this Shape's y position.
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * Returns the NestingShape that contains the Shape that method parent
     * is called on. If the callee object is not a child with in a
     * NestingShape instance this method returns null .
     */
    public NestingShape parent() {

        return this.parent != null ? this.parent : null;
    }

    /**
     * Returns an ordered list of Shape objects. The first item with in
     * the list is the root NestingShape of the containment hierarchy .
     * The last item with in the list is the callee object (hence this
     * method always returns a list with at least one item ) . Any
     * intermediate items are NestingShapes that connect the root
     * NestingShape to the callee Shape. E.g., given :
     * <p>
     * NestingShape root = new NestingShape();
     * NestingShape intermediate = new NestingShape();
     * Shape oval = new OvalShape() ;
     * root.add(intermediate) ;
     * intermediate.add (oval);
     * <p>
     * a call to oval.path() yields : [root ,intermediate ,oval]
     */
    public List<Shape> path() {
        List<Shape> path = (parent == null) ? new ArrayList<>() : parent.path();
        path.add(this);
        return path;
    }

    /**
     * Returns this Shape's text.
     */
    public String text() {
        return this.text;
    }

    /**
     * Returns this Shape's center position of X-axis.
     */
    public int centerX() {
        return x + width / 2;
    }

    /**
     * Returns this Shape's center position of Y-axis.
     */
    public int centerY() {
        return y + height / 2;
    }

    /**
     * Paints the centered text for this shape.
     * This is a hook method of draw(Template Method)
     */
    public void paintText(Painter painter) {
        painter.drawCentredText(centerX(), centerY(), text);
    }

    /**
     * This is a template method of painting shape and text.
     */
    public void draw(Painter painter) {
        paint(painter);
        paintText(painter);
    }

}
