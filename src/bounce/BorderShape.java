package bounce;

import java.util.ArrayList;
import java.util.List;

public class BorderShape extends Shape {
    protected static final int DEFAULT_PADDING = 2;

    protected int paddingNum;

    protected Shape innerShape;

    protected List<RectangleShape> borders;

    public BorderShape(Shape innerShape) {
        this.innerShape = innerShape;
        this.paddingNum = DEFAULT_PADDING;
    }

    public BorderShape(Shape innerShape, int paddingNum) {
        this.innerShape = innerShape;
        this.paddingNum = paddingNum;
    }

    public Shape getInnerShape() {
        return innerShape;
    }

    public List<RectangleShape> getBorders() {
        return borders;
    }

    @Override
    public void paint(Painter painter) {
        setBorderShapeVariable(innerShape, painter.getWorldWidth(), painter.getWorldHeight());
        //draw innerShape
        innerShape.paint(painter);
        painter.drawBorderShapes(this.borders);
    }

    private void setBorderShapeVariable(Shape innerShape, int worldWidth, int worldHeight) {
        borders = new ArrayList<>();
        for (int i = 1; i <= paddingNum; i++) {
            int borderX = innerShape.x() - 2 * i;
            int borderY = innerShape.y() - 2 * i;
            int borderWidth = innerShape.width() + 2 * 2 * i;
            int borderHeight = innerShape.height() + 2 * 2 * i;
            boolean isBeyondWidth = (worldWidth - borderX -borderWidth) < 0 ;
            boolean isBeyondHeight = (worldHeight - borderY - borderHeight) < 0;
            if(borderX < 0 || borderY <0 || isBeyondWidth || isBeyondHeight) break;
            borders.add(new RectangleShape(borderX, borderY, innerShape.deltaX(), innerShape.deltaY(),
                    borderWidth, borderHeight));

        }

    }

}
