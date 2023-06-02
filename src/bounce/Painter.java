package bounce;

import java.awt.*;
import java.util.List;

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
     * Draws a gemshape. Parameters x and y specify the top left corner of the
     * oval. Parameters width and height specify its width and height.
     */
    void drawGemShape(int x, int y, int width, int height);

    void fillRect(int x, int y, int width, int height);

    Color getColor();

    void setColor(Color color);

    void drawDynamicRectangle(int x, int y, int width, int height,boolean isSolid);
    void drawBorderShapes(List<RectangleShape> borders);
    int getWorldWidth();
    void setWorldWidth(int width);
    int getWorldHeight();
    void setWorldHeight(int height);

}
