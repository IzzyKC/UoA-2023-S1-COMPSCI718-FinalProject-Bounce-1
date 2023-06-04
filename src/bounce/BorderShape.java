package bounce;

import java.util.List;

public class BorderShape extends Shape {
    protected static final int DEFAULT_PADDING = 2;

    protected int paddingNum;

    protected Shape innerShape;

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
        this.bounceLogic.getBorderShapeItemsShapes().clear();
        this.bounceLogic.getBorderShapeItemsShapes().add(innerShape);
        generateBorders(innerShape);
        painter.drawBorderShapes(this.bounceLogic.getBorderShapeItemsShapes());
    }

    private void generateBorders(Shape innerShape) {
        int borderX = innerShape.x();
        int borderY = innerShape.y();
        int borderWidth = innerShape.width();
        int borderHeight = innerShape.height();

        for (int i = 1; i <= paddingNum; i++) {
            borderX = borderX - 2;
            borderY = borderY - 2;
            borderWidth = borderWidth + (2 + 2);
            borderHeight = borderHeight + (2 + 2);
            this.bounceLogic.getBorderShapeItemsShapes().add(new RectangleShape(borderX, borderY,
                    innerShape.deltaX(), innerShape.deltaY(), borderWidth, borderHeight));
        }

        this.x = borderX;
        this.y = borderY;
        this.deltaX = innerShape.deltaX();
        this.deltaY = innerShape.deltaY();
        this.width = borderWidth;
        this.height = borderHeight;

    }

}
