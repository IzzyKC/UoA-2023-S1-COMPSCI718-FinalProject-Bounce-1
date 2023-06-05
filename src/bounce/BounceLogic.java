package bounce;

import java.util.ArrayList;
import java.util.List;

public class BounceLogic {
    //observers of BorderShape
    private List<Shape> borderShapeItems = new ArrayList<>();

    /**
     * Returns the list of a BorderShape items
     */
    public List<Shape> getBorderShapeItemsShapes() {
        return borderShapeItems;
    }

    /**
     * Changes the value of deltaY when a BorderShape object pass beyond its world width
     */
    public void changeBorderShapeItemDeltaX(int newDeltaX) {
        if (borderShapeItems == null || borderShapeItems.size() == 0) return;
        for (Shape s : borderShapeItems)
            s.setDeltaX(newDeltaX);
    }

    /**
     * Changes the value of deltaY when a BorderShape object pass beyond its height
     */
    public void changeBorderShapeItemDeltaY(int newDeltaY) {
        if (borderShapeItems == null || borderShapeItems.size() == 0) return;
        for (Shape s : borderShapeItems)
            s.setDeltaY(newDeltaY);
    }

    /**
     * Moves a BorderShape object(including its innerShape and borders)
     * by arguments deltaX and deltaY within specified width and height.
     */
    public void moveBorderShapeItems(int width, int height, int deltaX, int deltaY) {
        if (borderShapeItems == null || borderShapeItems.size() == 0) return;
        for (Shape s : borderShapeItems) {
            s.move(width, height);
            s.setDeltaX(deltaX);
            s.setDeltaY(deltaY);
        }
    }

}
