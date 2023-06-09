package bounce;

import java.util.ArrayList;
import java.util.List;

public class BorderShape extends Shape {
    protected static final int DEFAULT_PADDING = 2;

    protected int paddingNum;

    protected Shape innerShape;

    protected List<Shape> borderRects = new ArrayList<>();

    public BorderShape(Shape innerShape) {
        this(innerShape, DEFAULT_PADDING);
    }

    public BorderShape(Shape innerShape, int paddingNum) {
        this.innerShape = innerShape;
        this.paddingNum = paddingNum;
        //sets the deltaX and DeltaY of this BorderShape object by its InnerShape object
        this.deltaX = innerShape.deltaX();
        this.deltaY = innerShape.deltaY();
    }

    /**
     * returns the padding number
     *
     * @return padding number
     */
    public int getPaddingNum() {
        return paddingNum;
    }

    /**
     * returns a list of borders
     *
     * @return list of borders
     */
    public List<Shape> getBorderRects() {
        return borderRects;
    }

    /**
     * paints the innerShape object and its borders
     *
     * @param painter the Painter object used for drawing.
     */
    @Override
    public void paint(Painter painter) {
        generateBorders(innerShape);
        innerShape.draw(painter);
        for (Shape s : borderRects) {
            s.draw(painter);
        }
    }

    /**
     * creates all shape objects within this BorderShape Object
     *
     * @param innerShape a given shape within a BorderShape object
     */
    private void generateBorders(Shape innerShape) {
        this.borderRects.clear();
        int borderX = innerShape.x();
        int borderY = innerShape.y();
        int borderWidth = innerShape.width();
        int borderHeight = innerShape.height();

        for (int i = 1; i <= paddingNum; i++) {
            borderX = borderX - 2;
            borderY = borderY - 2;
            borderWidth = borderWidth + (2 + 2);
            borderHeight = borderHeight + (2 + 2);
            borderRects.add(new RectangleShape(borderX, borderY,
                    innerShape.deltaX(), innerShape.deltaY(), borderWidth, borderHeight));
        }
    }

    /**
     * calculates the x,y,width and height of this BorderShape object by its InnerShape
     * move this borderShape, then calculates the innerShape position
     * and updates the deltaX and deltaY of innerShape after moving
     * Note: if bounce off walls , deltaX or deltaY changes for different moving directions
     *
     * @param width  width of two-dimensional world.
     * @param height height of two-dimensional world.
     */
    @Override
    public void move(int width, int height) {
        this.x = innerShape.x() - 2 * paddingNum;
        this.y = innerShape.y() - 2 * paddingNum;
        this.width = innerShape.width() + 2 * 2 * paddingNum;
        this.height = innerShape.height() + 2 * 2 * paddingNum;
        super.move(width, height);
        innerShape.setX(x + 2 * paddingNum);
        innerShape.setY(y + 2 * paddingNum);
        innerShape.setDeltaX(deltaX);
        innerShape.setDeltaY(deltaY);
    }

}
