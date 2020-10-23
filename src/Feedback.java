import javax.swing.*;
import java.awt.*;
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
    private JCheckBox otherFeed;
    private JCheckBox complaintsCheckBox;
    private JTextArea otherFeedText;
    private JTextArea complaintsText;
    private JPanel feedbackPanel;
    private JButton saveButton;
    private static JMenu menu;
    private static JMenuBar menubar;
    private static JMenuItem m1, m2, m3;

    int rate1 = 0;
    int rate2 = 0;
    String complaint = "";
    String otherfeed = "";

    public Feedback() {

        feedbackPanel = new JPanel();
        feedbackPanel.setLayout(new GridBagLayout());
        feedbackPanel.setMinimumSize(new Dimension(300, 400));
        feedbackPanel.setPreferredSize(new Dimension(400, 400));
        final JLabel label1 = new JLabel();
        label1.setPreferredSize(new Dimension(100, 20));
        label1.setText("Assistance Rate");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 10, 0);
        feedbackPanel.add(label1, gbc);

        b1 = new JRadioButton();
        b1.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        feedbackPanel.add(b1, gbc);
        b2 = new JRadioButton();
        b2.setText("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        feedbackPanel.add(b2, gbc);
        b3 = new JRadioButton();
        b3.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        feedbackPanel.add(b3, gbc);
        b4 = new JRadioButton();
        b4.setText("4");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        feedbackPanel.add(b4, gbc);
        b5 = new JRadioButton();
        b5.setText("5");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        feedbackPanel.add(b5, gbc);
        final JLabel label2 = new JLabel();
        label2.setMinimumSize(new Dimension(80, 20));
        label2.setPreferredSize(new Dimension(80, 20));
        label2.setText("Overall Rate");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 10, 0);
        feedbackPanel.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setPreferredSize(new Dimension(130, 20));
        label3.setText("Rate your Experience");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 15, 0);
        feedbackPanel.add(label3, gbc);
        otherFeed = new JCheckBox();
        otherFeed.setMinimumSize(new Dimension(60, 20));
        otherFeed.setPreferredSize(new Dimension(60, 25));
        otherFeed.setText("Other");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 0);
        feedbackPanel.add(otherFeed, gbc);
        complaintsCheckBox = new JCheckBox();
        complaintsCheckBox.setPreferredSize(new Dimension(90, 25));
        complaintsCheckBox.setText("Complaints");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 20, 0);
        feedbackPanel.add(complaintsCheckBox, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Customer Feedback");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 20, 0);
        feedbackPanel.add(label4, gbc);
        a1 = new JRadioButton();
        a1.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        feedbackPanel.add(a1, gbc);
        a2 = new JRadioButton();
        a2.setText("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        feedbackPanel.add(a2, gbc);
        a5 = new JRadioButton();
        a5.setText("5");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        feedbackPanel.add(a5, gbc);
        a3 = new JRadioButton();
        a3.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        feedbackPanel.add(a3, gbc);
        a4 = new JRadioButton();
        a4.setText("4");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        feedbackPanel.add(a4, gbc);
        otherFeedText = new JTextArea();
        otherFeedText.setColumns(15);
        otherFeedText.setLineWrap(false);
        otherFeedText.setMinimumSize(new Dimension(1, 17));
        otherFeedText.setRows(5);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        feedbackPanel.add(otherFeedText, gbc);
        complaintsText = new JTextArea();
        complaintsText.setColumns(15);
        complaintsText.setMinimumSize(new Dimension(15, 5));
        complaintsText.setRows(5);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        feedbackPanel.add(complaintsText, gbc);
        saveButton = new JButton();
        saveButton.setText("Save");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        feedbackPanel.add(saveButton, gbc);
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(a1);
        buttonGroup.add(a2);
        buttonGroup.add(a3);
        buttonGroup.add(a4);
        buttonGroup.add(a5);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(b1);
        buttonGroup.add(b2);
        buttonGroup.add(b3);
        buttonGroup.add(b4);
        buttonGroup.add(b5);

        otherFeedText.setEnabled(false);
        complaintsText.setEnabled(false);

        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rate1 = 1;
            }
        });
        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rate1 = 2;
            }
        });
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rate1 = 3;
            }
        });
        a4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rate1 = 4;
            }
        });
        a5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rate1 = 5;
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rate2 = 1;
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rate2 = 2;
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rate2 = 3;
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rate2 = 4;
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rate2 = 5;
            }
        });

        otherFeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                otherFeedText.setEnabled(true);
            }
        });
        complaintsCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                complaintsText.setEnabled(true);

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (otherFeedText.isEnabled()) {
                    otherfeed = otherFeedText.getText();
                }
                if (complaintsText.isEnabled()) {
                    complaint = complaintsText.getText();
                }
                int done = Database.feedback(rate1, rate2, complaint, otherfeed);
                if (done == 0){
                    JOptionPane.showMessageDialog(null, "Thank you for your feedback! ");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Failed to update. Try again!");
                }

            }
        });
    }

    public static void main() {
        JFrame frame = new JFrame("Feedback");
        frame.setContentPane(new Feedback().feedbackPanel);
        menubar = new JMenuBar();
        menu = new JMenu("Menu");
        m1 = new JMenuItem("Login");
        m2 = new JMenuItem("Home");
        m3 = new JMenuItem("Exit");
        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        menubar.add(menu);
        frame.setJMenuBar(menubar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client c = new Client();
                c.main(new String[]{});
                frame.dispose();

            }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Showroom.main();
                frame.dispose();

            }
        });
        m3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

    }

}
