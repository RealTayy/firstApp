import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a test for updating GitHubFiles
 */
public class testMenu {
    private JPanel mainPanel;
    private JButton num1;
    private JButton num2;
    private JButton num3;
    private JButton num4;
    private JButton let1;
    private JButton let2;
    private JButton let3;
    private JButton let4;
    private JTextField numberLabel;
    private JTextArea middleText;
    private JTextArea leftText;
    private JTextArea rightText;
    private JTextField letterLabel;

    public testMenu() {
        //Action Listeners for increasing Number Value
        num1.addActionListener(new numButtonClicked(1));
        num2.addActionListener(new numButtonClicked(2));
        num3.addActionListener(new numButtonClicked(3));
        num4.addActionListener(new numButtonClicked(4));

        //Action Listeners for increase Letter Value
        let1.addActionListener(new letButtonClicked(1));
        let2.addActionListener(new letButtonClicked(2));
        let3.addActionListener(new letButtonClicked(3));
        let4.addActionListener(new letButtonClicked(4));
    }

    public class numButtonClicked implements ActionListener {
        int value;

        public numButtonClicked(int value){
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = leftText.getText();
            int currentValue = Integer.valueOf(currentText);
            int newValue = value + currentValue;
            String newText = Integer.toString(newValue);
            leftText.setText(newText);
            //The 4 above line is equal to the next line but isn't very readable
            // can be shortened to -> leftText.setText(Integer.toString(value + Integer.valueOf(leftText.getText())));
            middleText.setText(leftText.getText()+rightText.getText());
        }
    }

    public class letButtonClicked implements ActionListener {
        int buttonValue;
        int currentValue;
        int newValue;
        String newText;

        String finalText;

        public letButtonClicked(int value){
            this.buttonValue = value;
        }

        public String intToString(int i) {
            int j = i/26; //quotient
            int k = i%26; //remainder
            char letter = (char)(k + 'A');
            if (j == 0){
                return String.valueOf(letter);
            } else {
                return intToString(j - 1) + letter;
            }
        }

        public int stringToInt(String string) {
            int totalValue = -1;
            for (int i = 0; string.length() >= 1; i++) {
                int charValue = (string.charAt(string.length() - 1) - 'A');
                int loopValue = (charValue + 1) * (int)Math.pow(26, i);
                totalValue += loopValue;
                string = string.substring(0, string.length() - 1);
            }
            return totalValue;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            currentValue = stringToInt(rightText.getText());
            newValue = buttonValue + currentValue;
            newText = intToString(newValue);
            rightText.setText(newText);
            middleText.setText(leftText.getText()+rightText.getText());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Piece of crap App");
        frame.setContentPane(new testMenu().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


