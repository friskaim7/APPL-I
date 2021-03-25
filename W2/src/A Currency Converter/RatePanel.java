// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

public class RatePanel extends JPanel {
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JLabel result, currencyLabel, inputLabel;
    private JComboBox comboBox;
    private JTextField textField;

    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel() {
        JLabel title = new JLabel("How much is that in dollars?");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Helvetica", Font.BOLD, 20));
        title.setBorder(new EmptyBorder(10, 10, 30, 10));

        // Set up the arrays for the currency conversions
        currencyName = new String[] {
                "European Euro","Canadian Dollar","Japanese Yen",
                "Australian Dollar", "Indian Rupee", "Mexican Peso" };
        rate = new double[] {1.2103, 0.7351, 0.0091, 0.6969, 0.0222, 0.0880 };

        result = new JLabel(" ------------ ");
        result.setBorder(new EmptyBorder(10, 10, 10, 10));

        currencyLabel = new JLabel("Select a currency name");
        comboBox = new JComboBox<String>(currencyName);
        comboBox.addActionListener(new ComboListener());

        inputLabel = new JLabel("Type the nominal");
        textField = new JTextField("1", 11);
        
        setBackground(new Color(240, 230, 255));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(title, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
        add(inputLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        add(textField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        add(currencyLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        add(comboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(result, gbc);
    }
    
    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    private class ComboListener implements ActionListener {
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
        public void actionPerformed(ActionEvent event) {
            int index = comboBox.getSelectedIndex();
            double nominal = Double.parseDouble(textField.getText());
            result.setText(nominal + " " + currencyName[index] + " = " + (rate[index] * nominal)
                    + " U.S. Dollars");
        }
    }
}