package bounce;

import java.awt.*;

/**
 * Interface to represent a type that offers primitive drawing methods.
 *
 * @author Ian Warren
 */
public interface Painter {
    /**
     * Draws a rectangle. Parameters x and y specify the top left corner of the
     * oval. Parameters width and height specify its width and height.
     */
    void drawRect(int x, int y, int width, int height);

    /**
     * Draws an oval. Parameters x and y specify the top left corner of the
     * oval. Parameters width and height specify its width and height.
     */
    void drawOval(int x, int y, int width, int height);

    /**
     * Draws a GemShape from left-most vertex and proceeding in a clockwise direction
     */
    void drawGemShape(int x, int y, int width, int height);

    /**
     * Draws a filled rectangle with specified color. Parameters x and y specify the top left corner of the
     * oval. Parameters width and height specify its width and height.
     */
    void fillRect(int x, int y, int width, int height, Color color);

    /**
     * return the current color
     *
     * @return current color
     */
    Color getColor();

    /**
     * sets the value of color
     *
     * @param color specified color
     */
    void setColor(Color color);

    /**
     * draws centered text of any shape object
     * @param x x position
     * @param y y position
     * @param text printed text
     */
    void drawCentredText(int x, int y, String text);

    /**
     * adjust the coordinate system by specifying a new origin
     * that corresponds toa point in the original coordinate system.
     * @param x x position
     * @param y y position
     */
    void translate(int x, int y);


}
