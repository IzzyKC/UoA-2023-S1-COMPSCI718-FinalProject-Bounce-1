package bounce;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * Simple GUI program to show an animation of shapes. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of
 * AnimationViewer can be added to a JFrame object. A JFrame object is a
 * window that can be closed, minimised, and maximised. The state of an
 * AnimationViewer object comprises a list of Shapes and a Timer object. An
 * AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates
 * through a list of Shapes requesting that each Shape paints and moves itself.
 *
 * @author Ian Warren
 */
@SuppressWarnings("serial")
public class AnimationViewer extends JPanel implements ActionListener {
    // Frequency in milliseconds for the Timer to generate events.
    private static final int DELAY = 20;

    // Collection of Shapes to animate.
    private List<Shape> shapes;

    private Timer timer = new Timer(DELAY, this);

    /**
     * Creates an AnimationViewer instance with a list of Shape objects and
     * starts the animation.
     */
    public AnimationViewer() {
        shapes = new ArrayList<>();

        // Populate the list of Shapes.
        shapes.add(new RectangleShape(0, 0, 2, 3));
        shapes.add(new RectangleShape(10, 10, 5, 7));
        shapes.add(new OvalShape("Default"));
        shapes.add(new OvalShape(30, 30, 10, 20));
        shapes.add(new OvalShape(30, 30, 5, 3, 50, 60, "Oval"));
        shapes.add(new OvalShape(20, 70, 5, 5, 20, 70));
        shapes.add(new GemShape(20, 70, 3, 6));
        shapes.add(new GemShape(20, 70, 5, 5, 70, 50));
        shapes.add(new GemShape(20, 70, 5, 5, 200, 200, "Hexagon"));
        shapes.add(new DynamicRectangleShape(450, 450, "DR", Color.CYAN));
        shapes.add(new DynamicRectangleShape(30, 50, 7, 5, 100, 50, "DR-YELLOW", Color.YELLOW));
        shapes.add(new DynamicRectangleShape(120, 250, 3, 5, 75, 75, "DR-PINK", Color.PINK));
        shapes.add(new DynamicRectangleShape(20, 70, 3, 5, 75, 50, "DR-GREEN", Color.GREEN));
        shapes.add(new BorderShape(new OvalShape(0, 0, 2, 3, 80, 45, "InnerShape"), 5));
        shapes.add(new BorderShape(new GemShape(120, 100, 6, 3, 35, 45), 10));
        shapes.add(new BorderShape(new GemShape(120, 100, 4, 3, 90, 45, "DF_BORDER")));


        //add NestingShape
        try {
            NestingShape topLevelNest = new NestingShape(0, 0, 2, 2, 250, 250, "Top");
            NestingShape midLevelNest = new NestingShape(0, 0, 1, 1, 150, 150, "Mid");
            NestingShape bottomLevelNest = new NestingShape(2, 2, 2, 2, 50, 50, "Btm");
            Shape gemShape = new GemShape(50, 50, 1, 1, 35, 45);
            Shape borderShape = new BorderShape(new OvalShape(50, 60, 3, 3, 20, 30, "4"), 4);
            Shape simpleShape = new DynamicRectangleShape(50, 50, 5, 6, 25, 20, "M2", Color.RED);
            Shape simpleShape2 = new DynamicRectangleShape(1, 1, 1, 2, 15, 20, "B1", Color.BLUE);
            bottomLevelNest.add(simpleShape2);
            midLevelNest.add(bottomLevelNest);
            midLevelNest.add(simpleShape);
            midLevelNest.add(gemShape);
            topLevelNest.add(borderShape);
            topLevelNest.add(midLevelNest);
            shapes.add(topLevelNest);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Start the animation.
        timer.start();
    }

    /**
     * Called by the Swing framework whenever this AnimationViewer object
     * should be repainted. This can happen, for example, after an explicit
     * repaint() call or after the window that contains this AnimationViewer
     * object has been opened, exposed or moved.
     */
    public void paintComponent(Graphics g) {
        // Call inherited implementation to handle background painting.
        super.paintComponent(g);

        // Calculate bounds of animation screen area.
        int width = getSize().width;
        int height = getSize().height;

        // Create a GraphicsPainter that Shape objects will use for drawing.
        // The GraphicsPainter delegates painting to a basic Graphics object.
        Painter painter = new GraphicsPainter(g);

        // Progress the animation.
        for (Shape s : shapes) {
            s.draw(painter);
            s.move(width, height);
        }
    }

    /**
     * Notifies this AnimationViewer object of an ActionEvent. ActionEvents are
     * received by the Timer.
     */
    public void actionPerformed(ActionEvent e) {
        // Request that the AnimationViewer repaints itself. The call to
        // repaint() will cause the AnimationViewer's paintComponent() method
        // to be called.
        repaint();
    }


    /**
     * Main program method to create an AnimationViewer object and display this
     * within a JFrame window.
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Animation viewer");
                frame.add(new AnimationViewer());

                // Set window properties.
                frame.setSize(500, 500);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
