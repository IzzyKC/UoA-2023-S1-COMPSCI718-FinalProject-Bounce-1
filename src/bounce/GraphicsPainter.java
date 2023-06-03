package bounce;

import java.awt.*;
import java.util.List;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 *
 * @author Ian Warren
 */
public class GraphicsPainter implements Painter {
    // Delegate object.
    private Graphics g;

    private int worldWidth;

    private int worldHeight;

    /**
     * Creates a GraphicsPainter object and sets its Graphics delegate.
     */
    public GraphicsPainter(Graphics g) {
        this.g = g;
    }

    /**
     * see bounce.Painter.drawRect
     */
    public void drawRect(int x, int y, int width, int height) {
        g.drawRect(x, y, width, height);
    }

    /**
     * see bounce.Painter.drawOval
     */
    public void drawOval(int x, int y, int width, int height) {
        g.drawOval(x, y, width, height);
    }

    /**
     * see bounce.Painter.drawGemShape
     * draw two types of GemShape by its width parameter
     * if the width of a Gemshape is less than 40 pixels, the top-left and top-right
     * vertices are both positioned at point (x+width/2, y). Similarly, the bottom-left and
     * bottom-right vertices are both positioned at point (x+width/2, y+height). In other
     * words, “small” GemShapes are four-sided figures.
     * drawing starts from left-most vertex and proceeding in a clock-wise direction.
     */
    @Override
    public void drawGemShape(int x, int y, int width, int height) {
        Polygon gemShape = new Polygon();
        if (width < 40) {
            //add four sides diamond
            gemShape.addPoint(x, y + height / 2);
            gemShape.addPoint(x + width / 2, y);
            gemShape.addPoint(x + width, y + height / 2);
            gemShape.addPoint(x + width / 2, y + height);
        } else {
            //add six sides hexagon
            gemShape.addPoint(x, y + height / 2);
            gemShape.addPoint(x + 20, y);
            gemShape.addPoint(x + width - 20, y);
            gemShape.addPoint(x + width, y + height / 2);
            gemShape.addPoint(x + width - 20, y + height);
            gemShape.addPoint(x + 20, y + height);
        }
        g.drawPolygon(gemShape);
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
        g.fillRect(x,y,width,height);
    }

    @Override
    public Color getColor() {
        return g.getColor();
    }

    @Override
    public void setColor(Color color) {
        g.setColor(color);
    }

    @Override
    public void drawDynamicRectangle(int x, int y, int width, int height, boolean isSolid) {
        if(isSolid)
            fillRect(x,y,width,height);
        else
            drawRect(x,y,width,height);
    }

    @Override
    public void drawBorderShapes(List<Shape> borders) {
       if(borders == null || borders.size()==0) return;
       for(Shape s : borders)
           s.paint(this);
    }
    @Override
    public void drawCentredText() {

    }
}
