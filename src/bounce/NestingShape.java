package bounce;

public class NestingShape extends Shape{
    /**
     * creates a NestingShape Object with default values for state.
     */
    public NestingShape(){
        super();
    }

    /**
     * creates a NestingShape object with specified location values,
     * default values for other state items.
     */
    public NestingShape(int x, int y){
        super(x,y);
    }
    /**
     * creates a NestingShape with specified values for location,velocity and direction.
     * Non-specified state items take on default values.
     */
    public NestingShape(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY);
    }

    /**
     * creates a NestingShape with specified values for location,velocity and direction,
     * width and height.
     */
    public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);
    }

    /**
     * Moves a NestingShape object(including its children) within the bounds
     * speccified by arguments width and height.
     */
    public void move(){

    }

    /**
     * paints a NestingShape object by drawing a rectangle around the edge of its bounding box.
     * The NestingShape object's children are then painted.
     */
    @Override
    public void paint(Painter painter) {

    }

    /**
    * Attempts to add a Shape to a NestingShape object. If successful, a
    * two-way link is established between the NestingShape and the newly
    * added Shape. Note that this method has package visibility-for reasons
    * that will become apparent in Bounce I I I .
    * @param shape the shape to be added.
    * @throws IllegalArgumentException if an attempt is made to add a Shape
    * to a NestingShape instance where the Shape argument is already a child
     * wwithin a NestingShape instance. An IllegalArgumentException is also
    * thrown when an attempt is made to add a Shape that will not fit within
    * the bounds of the proposed NestingShape object .
    */
    public void add(Shape shape) throws IllegalArgumentException {

    }
    /**
     * Removes a particular Shape from a NestingShape instance. Once removed,
     * the two-way link between the NestingShape and its former child is destroyed.
     * This method has no effect if the Shape specified to remove is not a child of
     * the NestingShape. Note that this method has package visibility - for reason that will
     * become apparent in Bounce III .
     * @param shape the shape to be removed .
     */
    public void remove (Shape shape){

    }

    /**
     * Returns the Shape at a specified position within a Nesting Shape. If the positon specified is
     * less than zero or greater than the number of children stored in the NestingShape less than one
     * this method throws an IndexOutBounds Exception.
     * @param index the specified index position
     */

    public Shape shapeAt (int index) throws IndexOutOfBoundsException{

        return null;
    }

    /**
     * Returns the number of children contained within a NestingShape object.
     * Note this method is not recursive = it simply returns the number of
     * children at the top level within the callee NestingShape object.
     */

    public int shapeCount(){

        return 0;
    }

    /**
     * Returns the index of a specified child with in a NestingShape object.
     * If the Shape specified is not actually a child of the NestingShape
     * this method returns =1; otherwise the value returned is in the range
     * 0 . . shapeCoun t ( ) = 1 .
     * @param shape whose indexposition with in the NestingShape is requested.
     */
    public int indexOf(Shape shape){

        return 0;
    }

    /**
     * Returns true if the Shape argument is a child of the NestingShape
     * object on which this method is called , false otherwise.
     */
    public boolean contains(Shape shape){

        return false;
    }



}
