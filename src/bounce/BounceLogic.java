package bounce;

import java.util.ArrayList;
import java.util.List;

public class BounceLogic {
    //filled style of dynamicRectangleShape
    private boolean isSolid;

    //observers
    private List<Shape> borderShapeItems = new ArrayList<>();

    public boolean isSolid() {
        return this.isSolid;
    }

    /**
     * After it bounces off the left or right wall it paints itself as a solid figure, in the
     * color specified at construction time. After it bounces off the top or bottom wall it switches its
     * appearance to that of a RectangleShape, i.e. rendering itself with an outline. If it bounces off both
     * walls, the vertical (left or right) wall determines its appearance.
     * @param isBounceOffVertical bounce off left or right walls
     * @param isBounceOffHorizontal bounces off top or bottom walls
     *                           //
     */

    public void setDynamicRectSolid(boolean isBounceOff, boolean isBounceOffVertical, boolean isBounceOffHorizontal) {
        if(!isBounceOff) return;
        if(isBounceOffVertical && isBounceOffHorizontal)
            this.isSolid = true;
        else if(isBounceOffVertical)
            this.isSolid = true;
        else if(isBounceOffHorizontal)
            this.isSolid = false;
    }

    public List<Shape> getBorderShapeItemsShapes() {
        return borderShapeItems;
    }

    public void changeBorderShapeItemDeltaX(int newDeltaX){
        if(borderShapeItems == null || borderShapeItems.size() == 0) return;
        for(Shape s : borderShapeItems)
            s.setDeltaX(newDeltaX);
    }
    public void changeBorderShapeItemDeltaY(int newDeltaY){
        if(borderShapeItems == null || borderShapeItems.size() == 0) return;
        for(Shape s : borderShapeItems)
            s.setDeltaY(newDeltaY);
    }

    public void moveBorderShapeItems(int width, int height, int deltaX, int deltaY){
        if(borderShapeItems == null || borderShapeItems.size() == 0) return;
        for(Shape s : borderShapeItems) {
            s.move(width, height);
            s.setDeltaX(deltaX);
            s.setDeltaY(deltaY);
        }
    }
}
