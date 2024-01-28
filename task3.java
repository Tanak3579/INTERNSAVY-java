import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task3 {

    private static final double USD_TO_EUR_RATE = 0.85;
    private static final double USD_TO_GBP_RATE = 0.74;
    // Add more currencies and rates as needed

    private JTextField amountField;
    private JComboBox<String> sourceCurrencyComboBox;
    private JComboBox<String> targetCurrencyComboBox;
    private JLabel resultLabel;

    public task3() {
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));

        // Components
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();

        JLabel sourceCurrencyLabel = new JLabel("Source Currency:");
        sourceCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP"/*, Add more currencies */});

        JLabel targetCurrencyLabel = new JLabel("Target Currency:");
        targetCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP"/*, Add more currencies */});

        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ");

        // Action listener for the convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        // Add components to the frame
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(sourceCurrencyLabel);
        frame.add(sourceCurrencyComboBox);
        frame.add(targetCurrencyLabel);
        frame.add(targetCurrencyComboBox);
        frame.add(new JLabel()); // Empty label for spacing
        frame.add(convertButton);
        frame.add(resultLabel);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private void convert() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String sourceCurrency = (String) sourceCurrencyComboBox.getSelectedItem();
            String targetCurrency = (String) targetCurrencyComboBox.getSelectedItem();

            double result = convertCurrency(amount, sourceCurrency, targetCurrency);

            resultLabel.setText("Result: " + amount + " " + sourceCurrency + " is equal to " + result + " " + targetCurrency);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        if (sourceCurrency.equals(targetCurrency)) {
            return amount; // No conversion needed
        }

        // Hardcoded exchange rates (replace with real-time rates)
        switch (sourceCurrency) {
            case "USD":
                switch (targetCurrency) {
                    case "EUR":
                        return amount * USD_TO_EUR_RATE;
                    case "GBP":
                        return amount * USD_TO_GBP_RATE;
                    // Add more cases for other currencies
                    default:
                        return amount;
                }
            case "EUR":
                switch (targetCurrency) {
                    case "USD":
                        return amount / USD_TO_EUR_RATE;
                    // Add more cases for other currencies
                    default:
                        return amount;
                }
            case "GBP":
                switch (targetCurrency) {
                    case "USD":
                        return amount / USD_TO_GBP_RATE;
                    // Add more cases for other currencies
                    default:
                        return amount;
                }
            // Add more cases for other source currencies
            default:
                return amount;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new task3();
            }
        });
    }
}
