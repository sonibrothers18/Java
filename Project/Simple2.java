import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simple2 {
    private JFrame frame;
    private JTextField amountField;
    private JComboBox<String> sourceCurrencyCombo;
    private JComboBox<String> targetCurrencyCombo;
    private JLabel resultLabel;

    // Exchange rates (you can update these as needed)
    private double[] exchangeRates = {
        1.0,      // USD
        0.85,     // Euro
        110.92,   // Japanese Yen
        83.2,     // India Rs
    };

    public Simple2() {
        frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));

        // Create components
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);
        sourceCurrencyCombo = new JComboBox<>(new String[]{"USD", "Euro", "Yen", "INR"});
        targetCurrencyCombo = new JComboBox<>(new String[]{"USD", "Euro", "Yen", "INR"});
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel();

        // Add components to the frame
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(new JLabel("From:"));
        frame.add(sourceCurrencyCombo);
        frame.add(new JLabel("To:"));
        frame.add(targetCurrencyCombo);
        frame.add(convertButton);
        frame.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            int sourceCurrencyIndex = sourceCurrencyCombo.getSelectedIndex();
            int targetCurrencyIndex = targetCurrencyCombo.getSelectedIndex();

            double result = amount * (exchangeRates[targetCurrencyIndex] / exchangeRates[sourceCurrencyIndex]);
            resultLabel.setText("Result: " + result + " " + targetCurrencyCombo.getSelectedItem());
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Simple2();
            }
        });
    }
}
