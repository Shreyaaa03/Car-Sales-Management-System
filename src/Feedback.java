import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Feedback {
    private JPanel feebackPanel;
    private JRadioButton a1;
    private JRadioButton a2;
    private JRadioButton a3;
    private JRadioButton a4;
    private JRadioButton a5;
    private JRadioButton b1;
    private JRadioButton b2;
    private JRadioButton b3;
    private JRadioButton b4;
    private JRadioButton b5;
    private JButton exit;
    private JCheckBox otherFeed;
    private JCheckBox complaintsCheckBox;
    private JTextArea otherFeedText;
    private JTextArea complaintsText;
    private JPanel feedbackPanel;
    private JButton Menu;

    public Feedback() {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sales.main(Client.role);
            }
        });
    }

    public static void main() {
        JFrame frame = new JFrame("Feedback");
        frame.setContentPane(new Feedback().feedbackPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
