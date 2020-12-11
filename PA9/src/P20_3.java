import javax.swing.*;
import java.awt.*;

/*
Write an application with three labeled text fields,
one each for the initial amount of a savings account, the annual interest rate,
and the number of years. Add a button “Calculate” and a read-only text area
to display the balance of the savings account after the end of each year
 */

public class P20_3 {
    private static double init = 0.0;
    private static double rate = 0.0;
    private static int years = 0;

    public static void main(String[] args) {
        setUp();

        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        calculate.addActionListener(actionEvent -> {
            try {
                text.setText(""); // reset textArea every time button clicked
                init = Double.parseDouble(initField.getText());
                rate = Double.parseDouble(rateField.getText());
                years = Integer.parseInt(yearField.getText());
                for (int i = 1; i <= years; i++) {
                    double balance = init * Math.pow((1 + rate / 100.0), i);
                    text.append(String.format("After year %d, balance = %.2f\n", i, balance));
                }
            } catch (Exception e) {
                text.setText("Invalid input: " + e.getMessage() + ". Please enter again.");
            }
        });

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(input);
        frame.add(calculate);
        frame.add(result);
    }

    /**
     * Setup and add components to input panel
     */
    public static void setUp() {
        text.setLineWrap(true);
        result.setPreferredSize(new Dimension(300, 350));
        result.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        input.setLayout(new GridLayout(3, 2));
        input.add(initLabel);
        input.add(initField);
        input.add(rateLabel);
        input.add(rateField);
        input.add(yearLabel);
        input.add(yearField);
    }

    // Components
    private static JPanel input = new JPanel();
    private static JLabel initLabel = new JLabel("Initial Amount: ", JLabel.CENTER);
    private static JLabel rateLabel = new JLabel("Annual Rate (%): ", JLabel.CENTER);
    private static JLabel yearLabel = new JLabel("Number of Years: ", JLabel.CENTER);
    private static JTextField initField = new JTextField();
    private static JTextField rateField = new JTextField();
    private static JTextField yearField = new JTextField();
    private static JButton calculate = new JButton("Calculate");
    private static JTextArea text = new JTextArea("Fill the form then click Calculate \n to see result balance for each year.");
    private static JScrollPane result = new JScrollPane(text);
}
