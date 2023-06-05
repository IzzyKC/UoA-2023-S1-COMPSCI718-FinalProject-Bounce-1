package bounce;

import java.util.ArrayList;
import java.util.List;

public class NestingShape extends Shape {

    //children of this NestingShape instance
    protected List<Shape> nestingShapes = new ArrayList<>();

    /**
     * creates a NestingShape Object with default values for state.
     */
    public NestingShape() {
        super();
    }

    public NestingShape(String text) {
        super(text);
    }

    /**
     * creates a NestingShape object with specified location values,
     * default values for other state items.
     */
    public NestingShape(int x, int y) {
        super(x, y);
    }

    public NestingShape(int x, int y, String text) {
        super(x, y, text);
    }

    /**
     * creates a NestingShape with specified values for location,velocity and direction.
     * Non-specified state items take on default values.
     */
    public NestingShape(int x, int y, int deltaX, int deltaY) {
        super(x, y, deltaX, deltaY);
    }

    public NestingShape(int x, int y, int deltaX, int deltaY, String text) {
        super(x, y, deltaX, deltaY, text);
    }

    /**
     * creates a NestingShape with specified values for location,velocity and direction,
     * width and height.
     */
    public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);
    }

    public NestingShape(int x, int y, int deltaX, int deltaY, int width,
                        int height, String text) {
        super(x, y, deltaX, deltaY, width, height, text);
    }

    /**
     * paints a NestingShape object by drawing a rectangle around the edge of its bounding box.
     * The NestingShape object's children are then painted.
     * adjust the coordinate system by specifying a new origin (the NestingShape’s top left corner)
     * that corresponds toa point in the original coordinate system.
     */
    @Override
    public void paint(Painter painter) {
        painter.drawRect(x, y, width, height);
        painter.translate(x, y);
        for (Shape s : this.nestingShapes) {
            s.paint(painter);
            if (s instanceof NestingShape && ((NestingShape) s).shapeCount() == 0) {
                painter.translate(-s.x(), -s.y());
                continue;
            }
            painter.translate(-s.parent.x(), -s.parent.y());
        }
    }

    /**
     * Attempts to add a Shape to a NestingShape object. If successful, a
     * two-way link is established between the NestingShape and the newly
     * added Shape. Note that this method has package visibility-for reasons
     * that will become apparent in Bounce III .
     *
     * @param shape the shape to be added.
     * @throws IllegalArgumentException if an attempt is made to add a Shape
     *                                  to a NestingShape instance where the Shape argument is already a child
     *                                  within a NestingShape instance. An IllegalArgumentException is also
     *                                  thrown when an attempt is made to add a Shape that will not fit within
     *                                  the bounds of the proposed NestingShape object .
     */
    public void add(Shape shape) throws IllegalArgumentException {
        if (shape.parent != null)
            throw new IllegalArgumentException("This shape already exists within another NestingShape instance!");
        if ((shape.x() + shape.width() > this.width()) || (shape.y() + shape.height() > this.height))
            throw new IllegalArgumentException("This shape cannot fit within the NestingShape instance!");
        shape.parent = this;
        nestingShapes.add(shape);
        this.bounceLogic.getSubNestingShapes().add(shape);
    }

    /**
     * Removes a particular Shape from a NestingShape instance. Once removed,
     * the two-way link between the NestingShape and its former child is destroyed.
     * This method has no effect if the Shape specified to remove is not a child of
     * the NestingShape. Note that this method has package visibility - for reason that will
     * become apparent in Bounce III .
     *
     * @param shape the shape to be removed .
     */
    public void remove(Shape shape) {
        if (shape == null) return;
        if (this.nestingShapes.contains(shape)) {
            shape.parent = null;
            this.nestingShapes.remove(shape);
        }
    }

    /**
     * Returns the Shape at a specified position within a Nesting Shape. If the positon specified is
     * less than zero or greater than the number of children stored in the NestingShape less than one
     * this method throws an IndexOutBounds Exception.
     *
     * @param index the specified index position
     */

    public Shape shapeAt(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > nestingShapes.size() - 1)
            throw new IndexOutOfBoundsException("The given index in invalid");

        return nestingShapes.get(index);
    }

    /**
     * Returns the number of children contained within a NestingShape object.
     * Note this method is not recursive = it simply returns the number of
     * children at the top level within the callee NestingShape object.
     */

    public int shapeCount() {
        return nestingShapes.size();
    }

    /**
     * Returns the index of a specified child within a NestingShape object.
     * If the Shape specified is not actually a child of the NestingShape
     * this method returns -1; otherwise the value returned is in the range
     * 0 . . shapeCount( )-1 .
     *
     * @param shape whose index position within the NestingShape is requested.
     */
    public int indexOf(Shape shape) {
        return nestingShapes.indexOf(shape);
    }

    /**
     * Returns true if the Shape argument is a child of the NestingShape
     * object on which this method is called , false otherwise.
     */
    public boolean contains(Shape shape) {
        if (this.nestingShapes == null || this.nestingShapes.size() == 0)
            return false;
        if (this.nestingShapes.contains(shape))
            return true;
        else
            return false;
    }

    /**
     * Moves a NestingShape object (including Children) within bounds
     * specified by arguments width and height.
     */
    public void move(int width, int height) {
        super.move(width, height);
        for (Shape s : nestingShapes) {
            s.move(s.parent.width(), s.parent.height());
        }
    }

    public void paintText(Painter painter) {
        super.paintText(painter);
        painter.translate(x, y);
        for (Shape s : nestingShapes) {
            s.paintText(painter);
        }
        painter.translate(-x, -y);
    }
}
