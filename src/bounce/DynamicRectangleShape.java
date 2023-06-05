package bounce;

import java.awt.*;

public class DynamicRectangleShape extends Shape {
    protected Color color;


    /**
     * Default constructor that creates a DynamicRectangleShape instance whose instance
     * variables are set to default values.
     */
    public DynamicRectangleShape() {
        super();
        this.color = DEFAULT_COLOR;
    }

    public DynamicRectangleShape(String text) {
        super(text);
        this.color = DEFAULT_COLOR;
    }

    /**
     * Default constructor that creates a DynamicRectangleShape instance with a specific color
     */
    public DynamicRectangleShape(Color color) {
        super();
        this.color = color;
    }

    /**
     * Creates a Shape object with a specified x and y position.
     */
    public DynamicRectangleShape(int x, int y) {
        super(x, y);
        this.color = DEFAULT_COLOR;

    }


    /**
     * Creates a Shape object with a specified x ,y and color.
     */
    public DynamicRectangleShape(int x, int y, Color color) {
        super(x, y);
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
        super(x, y, deltaX, deltaY);
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
        this.color = DEFAULT_COLOR;
    }
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height,String text) {
        super(x, y, deltaX, deltaY, width, height,text);
        this.color = DEFAULT_COLOR;
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

    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color color) {
        super(x, y, deltaX, deltaY, width, height, text);
        this.color = color;
    }

    /**
     * Paints this DynamicRectangleShape object using the supplied Painter object.
     * DynamicRectangleShape changes its appearance when it bounces.
     */
    @Override
    public void paint(Painter painter) {
        Color currentColor = painter.getColor();
        if (isBounceOffVertical) {
            painter.fillRect(x, y, width, height, color);
        } else {
            painter.drawRect(x, y, width, height);
        }
        painter.setColor(DEFAULT_COLOR);
    }

    public Color getColor() {
        return color;
    }

}
