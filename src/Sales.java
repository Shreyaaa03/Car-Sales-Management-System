import javax.swing.*;
import java.awt.*;
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
        if (user.equalsIgnoreCase("sales")){
            addAProductRadioButton.setVisible(false);
            removeAProductRadioButton.setVisible(false);
        }

        availableModels.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String model = availableModels.getSelectedItem().toString();
                String answer = Database.search(model);
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
                String model = availableModels.getSelectedItem().toString();
                int res = JOptionPane.showConfirmDialog(null, "Confirm the payment? ", "Confirmation Needed",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION){
                    int id = Database.getId(model);
                    double total = Database.purchase(id);
                    JOptionPane.showMessageDialog(null, "Total Price : "+total+"\nThank you for the payment!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Payment cancelled!");
                }

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        addAProductRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(new GridLayout(10, 10));
                JTextField text1 = new JTextField(10);
                JTextField text2 = new JTextField(10);
                JTextField text3 = new JTextField(10);
                JTextField text4 = new JTextField(10);
                JTextField text5 = new JTextField(10);

                Label l1,l2,l3,l4,l5;
                l1=new Label("Model ID");
                l1.setBounds(50,100, 100,30);
                l2=new Label("Model Name");
                l2.setBounds(50,150, 100,30);
                l3=new Label("Manufacturer Name");
                l3.setBounds(50,100, 100,30);
                l4=new Label("Quantity");
                l4.setBounds(50,150, 100,30);
                l5=new Label("Price");
                l5.setBounds(50,150, 100,30);

                panel.add(l1);
                panel.add(text1);
                panel.add(l2);
                panel.add(text2);
                panel.add(l3);
                panel.add(text3);
                panel.add(l4);
                panel.add(text4);
                panel.add(l5);
                panel.add(text5);

                JOptionPane.showMessageDialog(null, panel);

                int id = Integer.parseInt(text1.getText());
                String name = text2.getText();
                String manu = text3.getText();
                int qty = Integer.parseInt(text4.getText());
                double price = Double.parseDouble(text5.getText());

                Database.addProduct(id, name, manu, qty, price);

                availableModels.addItem(name);

            }
        });

        removeAProductRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(new GridLayout(5, 5));
                JTextField text1 = new JTextField(6);
                Label l1=new Label("Model ID");
                l1.setBounds(50,100, 100,30);
                panel.add(l1);
                panel.add(text1);
                JOptionPane.showMessageDialog(null, panel);

                int id = Integer.parseInt(text1.getText());
                String name = Database.remove(id);

                availableModels.removeItem(name);
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
