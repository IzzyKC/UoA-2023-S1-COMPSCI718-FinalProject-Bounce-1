package bounce;

import java.util.ArrayList;
import java.util.List;

public class BorderShape extends Shape {
    protected static final int DEFAULT_PADDING = 2;

    protected static final int borderGapPixel = 2;

    protected int paddingNum;

    protected Shape innerShape;

    protected List<Shape> borderItems = new ArrayList<>();

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

    @Override
    public void paint(Painter painter) {
        generateBorders(innerShape);
        for (Shape s : borderItems) {
            s.draw(painter);
        }
    }

    /**
     * counts the x,y,widthand height of a BorderShape object by a given innerShape
     *
     * @param innerShape a given shape within a BorderShape object
     */
    private void generateBorders(Shape innerShape) {
        this.borderItems.clear();
        this.borderItems.add(innerShape);
        int borderX = innerShape.x();
        int borderY = innerShape.y();
        int borderWidth = innerShape.width();
        int borderHeight = innerShape.height();

        for (int i = 1; i <= paddingNum; i++) {
            borderX = borderX - 2;
            borderY = borderY - 2;
            borderWidth = borderWidth + (2 + 2);
            borderHeight = borderHeight + (2 + 2);
            borderItems.add(new RectangleShape(borderX, borderY,
                    innerShape.deltaX(), innerShape.deltaY(), borderWidth, borderHeight));
        }
    }

    /**
     * paints text of a BorderShape object
     *
     * @param painter a painter
     */
    @Override
    public void paintText(Painter painter) {
        innerShape.paintText(painter);
    }

    /**
     * calculates the x,y,width and height of this BorderShape object by its InnerShape
     * move this borderShape, then calculates the innerShape position
     * and updates the deltaX and deltaY of innerShape after moving
     * @param width  width of two-dimensional world.
     * @param height height of two-dimensional world.
     */
    @Override
    public void move(int width, int height) {
        this.x = innerShape.x() - 2 * paddingNum;
        this.y = innerShape.y() - 2 * paddingNum;
        this.width = innerShape.width() + 2 * 2 * paddingNum;
        this.height = innerShape.height() + 2 * 2 * paddingNum;
        super.move(width,height);
        innerShape.setX(x+2*paddingNum);
        innerShape.setY(y+2*paddingNum);
        innerShape.setDeltaX(deltaX);
        innerShape.setDeltaY(deltaY);
    }

}
