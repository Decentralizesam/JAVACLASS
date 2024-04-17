import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class AdvanceCalculator extends JFrame {
    private JTextField displayField;
    private JButton[] numButtons;
    private JButton[] opButtons;
    private double currentValue;
    private String currentOperator;
    private boolean startNewInput;

    public AdvanceCalculator() {
        setTitle("Advanced Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        displayField.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "±", "+",
            "sin", "cos", "tan", "√",
            "C", "="
        };

        numButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numButtons[i].addActionListener(new NumButtonListener());
        }

        opButtons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            opButtons[i] = new JButton(buttonLabels[i]);
            opButtons[i].setFont(new Font("Arial", Font.BOLD, 16));
            opButtons[i].addActionListener(new OpButtonListener());

            if (buttonLabels[i].equals("=")) {
            } else if (buttonLabels[i].equals("C")) {
            }
        }

        for (JButton button : numButtons) {
            buttonPanel.add(button);
        }

        for (JButton button : opButtons) {
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);
        pack();
    }

    private class NumButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            
            if (startNewInput) {
                displayField.setText("");
                startNewInput = false;
            }
            
            displayField.setText(displayField.getText() + buttonText);
        }
    }

    private class OpButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();

            switch (buttonText) {
                case "+":
                case "-":
                case "*":
                case "/":
                    if (!startNewInput) {
                        calculate();
                    }
                    currentOperator = buttonText;
                    currentValue = Double.parseDouble(displayField.getText());
                    startNewInput = true;
                    break;
                case "=":
                    calculate();
                    break;
                case "C":
                    currentValue = 0;
                    currentOperator = "";
                    displayField.setText("");
                    startNewInput = false;
                    break;
                case ".":
                    if (!displayField.getText().contains(".")) {
                        displayField.setText(displayField.getText() + ".");
                    }
                    break;
                case "±":
                    double value = Double.parseDouble(displayField.getText());
                    displayField.setText(String.valueOf(-value));
                    break;
                case "sin":
                    double sinValue = Double.parseDouble(displayField.getText());
                    displayField.setText(formatResult(Math.sin(Math.toRadians(sinValue))));
                    break;
                case "cos":
                    double cosValue = Double.parseDouble(displayField.getText());
                    displayField.setText(formatResult(Math.cos(Math.toRadians(cosValue))));
                    break;
                case "tan":
                    double tanValue = Double.parseDouble(displayField.getText());
                    displayField.setText(formatResult(Math.tan(Math.toRadians(tanValue))));
                    break;
                case "√":
                    double sqrtValue = Double.parseDouble(displayField.getText());
                    displayField.setText(formatResult(Math.sqrt(sqrtValue)));
                    break;
            }
        }
    }

    private void calculate() {
        if (!startNewInput) {
            double newValue = Double.parseDouble(displayField.getText());
            switch (currentOperator) {
                case "+":
                    currentValue += newValue;
                    break;
                case "-":
                    currentValue -= newValue;
                    break;
                case "*":
                    currentValue *= newValue;
                    break;
                case "/":
                    currentValue /= newValue;
                    break;
            }
            displayField.setText(formatResult(currentValue));
        }
        startNewInput = true;
    }

    private String formatResult(double value) {
        DecimalFormat df = new DecimalFormat("#.##########");
        return df.format(value);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            new AdvanceCalculator().setVisible(true);
        });
    }
}

