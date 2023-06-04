package bounce;

import java.util.ArrayList;
import java.util.List;

public class BounceLogic {
    //filled style of dynamicRectangleShape
    private boolean isSolid;

    //observers of BorderShape
    private List<Shape> borderShapeItems = new ArrayList<>();

    //observers of NestingShape(children)
    private List<Shape> subNestingShapes = new ArrayList<>();

    /**
     * returns the boolean value of filled style
     *
     * @return the boolean value of filled style
     */
    public boolean isSolid() {
        return this.isSolid;
    }

    /**
     * set the filled style of a DynamicRectangleShape
     * After it bounces off the left or right wall it paints itself as a solid figure, in the
     * color specified at construction time. After it bounces off the top or bottom wall it switches its
     * appearance to that of a RectangleShape, i.e. rendering itself with an outline. If it bounces off both
     * walls, the vertical (left or right) wall determines its appearance.
     *
     * @param isBounceOffVertical   bounce off left or right walls
     * @param isBounceOffHorizontal bounces off top or bottom walls
     *                              //
     */
    public void setDynamicRectSolid(boolean isBounceOff, boolean isBounceOffVertical, boolean isBounceOffHorizontal) {
        if (!isBounceOff) return;
        if (isBounceOffVertical && isBounceOffHorizontal)
            this.isSolid = true;
        else if (isBounceOffVertical)
            this.isSolid = true;
        else if (isBounceOffHorizontal)
            this.isSolid = false;
    }

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

    /**
     * Returns the children list of a NestingShape
     */
    public List<Shape> getSubNestingShapes() {
        return subNestingShapes;
    }

    /**
     * Moves a NestingShape object(including its children) within the bounds
     * speccified by arguments width and height.
     */
    public void moveSubNestingShapes() {
        if(subNestingShapes == null || subNestingShapes.size() ==0) return;
        for(Shape s : subNestingShapes) {
            s.move(s.parent.width(), s.parent.height());
        }
    }
}
