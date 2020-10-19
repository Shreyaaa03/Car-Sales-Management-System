import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class Sales {
    private JComboBox availableModels;
    private JRadioButton AddFeedback;
    private JPanel salesPanel;
    private JTextArea specs;
    private JButton PurchaseButton;
    private JRadioButton topModelsRadioButton;
    private JButton exitButton;
    private JRadioButton addAProductRadioButton;
    private JRadioButton removeAProductRadioButton;
    private JTextArea topModels;

    public static String user = "";


    public Sales() {
        availableModels.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String model = availableModels.getSelectedItem().toString();
                String answer = Database.search(model);
                specs.setColumns(15);
                specs.setRows(15);
                specs.setText(answer);
            }
        });

        AddFeedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Feedback.main();
            }
        });

        topModelsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> topProducts = Database.topModels();
                System.out.println(topProducts);
                topModels.setText("Top Models:\nModel ID\tModelName\tOrders\n");
                for (String i : topProducts) {
                    topModels.append(i);
                }

            }
        });

        PurchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String role ) {
        user = role;
        JFrame frame = new JFrame("Sales");
        frame.setContentPane(new Sales().salesPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
