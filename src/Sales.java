import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Sales {
    private JComboBox availableModels;
    private JRadioButton AddFeedback;
    private JPanel salesPanel;
    private JTextArea specs;
    private JButton PurchaseButton;
    private JRadioButton topModelsRadioButton;


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

            }
        });

        topModelsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        PurchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public static void main() {
        JFrame frame = new JFrame("Sales");
        frame.setContentPane(new Sales().salesPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
