
// ******************************************************************
// SpeedControlPanel.java
//
// The panel for the bouncing ball. Similar to
// ReboundPanel.java in Listing 8.16 in the text, except a circle
// rather than a happy face is rebounding off the edges of the
// window.
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SpeedControlPanel extends JPanel {
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int BALL_SIZE = 50;
    private Circle bouncingBall; // the object that moves
    private Timer timer;
    private int moveX, moveY; // increment to move each time
    JSlider slider;
    JLabel label;
    JPanel slidePanel;

    // ---------------------------------------------
    // Sets up the panel, including the timer
    // for the animation
    // ---------------------------------------------
    public SpeedControlPanel() {
        timer = new Timer(30, new ReboundListener());
        this.setLayout(new BorderLayout());
        bouncingBall = new Circle(BALL_SIZE);
        moveX = moveY = 5;

        // Set up a slider object here
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        timer.start();
        
        slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 30);
        slider.setMajorTickSpacing(40);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setAlignmentX(JSlider.LEFT_ALIGNMENT);
        slider.addChangeListener(new SlideListener());

        label = new JLabel("Timer Delay");

        slidePanel = new JPanel();
        slidePanel.add(label);
        slidePanel.add(slider);

        this.add(slidePanel, "South");
    }

    // --------------------
    // Draw the ball
    // --------------------
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        bouncingBall.draw(page);
    }

    // ***************************************************
    // An action listener for the timer
    // ***************************************************
    public class ReboundListener implements ActionListener {
        // ----------------------------------------------------
        // actionPerformed is called by the timer -- it updates
        // the position of the bouncing ball
        // ----------------------------------------------------
        public void actionPerformed(ActionEvent action) {
            try {
                bouncingBall.move(moveX, moveY);

                // change direction if ball hits a side
                int x = bouncingBall.getX();
                int y = bouncingBall.getY();
                int slidePanelHt = slidePanel.getSize().height;

                if (x < 0 || x >= WIDTH - BALL_SIZE)
                    moveX = moveX * -1;
                if ((y <= 0) || (y >= HEIGHT - BALL_SIZE - slidePanelHt))
                    moveY = moveY * -1;
                repaint();

            } catch (NullPointerException e) {
                System.out.println("Something went wrong : " + e.toString());
            }
        }
    }

    // *****************************************************
    // A change listener for the slider.
    // *****************************************************
    private class SlideListener implements ChangeListener {
        // -------------------------------------------------
        // Called when the state of the slider has changed;
        // resets the delay on the timer.
        // -------------------------------------------------
        public void stateChanged(ChangeEvent event) {
            // This function must determine the value of the slider, then set the
            // timer delay to that value. The timer delay can be set with the method setDelay (int delay) in the Timer class.
            // Add the change listener to the JSlider object.
            timer.setDelay(slider.getValue());
        }
    }
}