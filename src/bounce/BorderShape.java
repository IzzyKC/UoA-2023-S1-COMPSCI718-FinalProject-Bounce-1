package bounce;

import java.util.ArrayList;
import java.util.List;

public class BorderShape extends Shape {
    protected static final int DEFAULT_PADDING = 2;

    protected int paddingNum;

    protected Shape innerShape;

    //protected List<Shape> borders;

    public BorderShape(Shape innerShape) {
        this.innerShape = innerShape;
        this.paddingNum = DEFAULT_PADDING;
    }

    public BorderShape(Shape innerShape, int paddingNum) {
        this.innerShape = innerShape;
        this.paddingNum = paddingNum;
        this.x = innerShape.x() - 2 * paddingNum;
        this.y = innerShape.y() - 2 * paddingNum;
        this.deltaX = innerShape.deltaX();
        this.deltaY = innerShape.deltaY();
        this.width = innerShape.width() + 2 * 2 * paddingNum;
        this.height = innerShape.height() + 2 * 2 * paddingNum;
    }

    public Shape getInnerShape() {
        return innerShape;
    }

    public List<Shape> getBorders() {
        return null;
    }

    @Override
    public void paint(Painter painter) {
        this.bounceOff.getShapes().clear();
        this.bounceOff.getShapes().add(innerShape);
        generateBorders(innerShape);
        painter.drawBorderShapes(this.bounceOff.getShapes());
    }

    private void generateBorders(Shape innerShape) {

        for (int i = 1; i <= paddingNum; i++) {
            int borderX = innerShape.x() - 2 * i;
            int borderY = innerShape.y() - 2 * i;
            int borderWidth = innerShape.width() + (2 + 2) * i;
            int borderHeight = innerShape.height() + (2 + 2) * i;
            this.bounceOff.getShapes().add(new RectangleShape(borderX, borderY,
                    innerShape.deltaX(), innerShape.deltaY(), borderWidth, borderHeight));
        }

    }

}
