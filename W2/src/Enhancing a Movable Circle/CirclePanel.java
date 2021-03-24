
// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CirclePanel extends JPanel {
    private final int CIRCLE_SIZE = 50;
    private int x, y;
    private int width, height;
    private Color c;
    private JButton left, right, up, down;
    JPanel buttonPanel;

    // ---------------------------------------------------------------
    // Set up circle and buttons to move it.
    // ---------------------------------------------------------------
    public CirclePanel(int width, int height) {
        this.width = width;
        this.height = height;
        
        // Set coordinates so circle starts in middle
        x = (width / 2) - (CIRCLE_SIZE / 2);
        y = (height / 2) - (CIRCLE_SIZE / 2);
        c = Color.green;

        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());

        // Create buttons to move the circle
        left = new JButton("Left");
        right = new JButton("Right");
        up = new JButton("Up");
        down = new JButton("Down");
        
        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20, 0));
        right.addActionListener(new MoveListener(20, 0));
        up.addActionListener(new MoveListener(0, -20));
        down.addActionListener(new MoveListener(0, 20));
        
        // Set mnemonics to the buttons
        left.setMnemonic('L');
        right.setMnemonic('r');
        up.setMnemonic('u');
        down.setMnemonic('d');
        
        // Set tooltips to the buttons
        left.setToolTipText("Move 20px to the left");
        right.setToolTipText("Move 20px to the right");
        up.setToolTipText("Move 20px above");
        down.setToolTipText("Move 20px below");
        
        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        buttonPanel.setBackground(Color.GRAY);
        
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
    }

    // ---------------------------------------------------------------
    // Draw circle on CirclePanel
    // ---------------------------------------------------------------
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
    }

    // ---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    // ---------------------------------------------------------------
    private class MoveListener implements ActionListener {
        private int dx;
        private int dy;

        // ---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        // ---------------------------------------------------------------
        public MoveListener(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        // ---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        // ---------------------------------------------------------------
        public void actionPerformed(ActionEvent e) {
            x += dx;
            y += dy;
            repaint();
            // When the circle gets all the way to an edge, disable the corresponding button
            if (x < (CIRCLE_SIZE/2) + dx) left.setEnabled(false); else left.setEnabled(true);
            if (y < (CIRCLE_SIZE/2) + dy) up.setEnabled(false); else up.setEnabled(true);
            if ((x + dx) > (width - CIRCLE_SIZE)) right.setEnabled(false); else right.setEnabled(true);
            if ((y + dy) > (height - CIRCLE_SIZE - dy - buttonPanel.getHeight())) down.setEnabled(false); else down.setEnabled(true);
        }
    }
}