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

        JFrame frame = new JFrame("Showroom");

        salesPanel = new JPanel(new GridLayout(10, 2, 10, 10));

        JLabel label1 = new JLabel("WELCOME", SwingConstants.CENTER);

        JLabel hl = new JLabel("", JLabel.CENTER);

        String[] models = {"Models", "Audi A8", "Range Rover", "Land Cruiser"};

        availableModels = new JComboBox(models);
        availableModels.setSize(70, 50);
        availableModels.setBounds(150, 120, 100, 30);

        specs = new JTextArea(100, 150);
        specs.setBounds(150, 120, 100, 150);
        //specs.setSize(100, 400);
        JScrollPane scroll = new JScrollPane(specs);
        //scroll.setSize( 150, 100 );
        //specs.setRows(200);
        //specs.resize(150, 300);
        //specs.setBounds(50,50,150,300);

        topModels = new JTextArea(100, 150);
        topModels.setBounds(150, 120, 100, 150);
        //topModels.setSize(100, 200);
        JScrollPane scroll1 = new JScrollPane(topModels);
        //topModels.setColumns(250);
        //scroll1.setSize( 150, 100 );


        ButtonGroup G = new ButtonGroup();
        addAProductRadioButton = new JRadioButton("Add a Product");
        addAProductRadioButton.setBounds(150, 120, 100, 30);
        removeAProductRadioButton = new JRadioButton("Remove a Product");
        removeAProductRadioButton.setBounds(150, 120, 100, 30);
        AddFeedback = new JRadioButton("Feedback");
        AddFeedback.setBounds(150, 120, 100, 30);
        topModelsRadioButton = new JRadioButton("Top Models");
        topModelsRadioButton.setBounds(150, 120, 100, 30);
        G.add(addAProductRadioButton);
        G.add(removeAProductRadioButton);
        G.add(AddFeedback);
        G.add(topModelsRadioButton);

        PurchaseButton = new JButton("Purchase");
        PurchaseButton.setHorizontalAlignment(JButton.CENTER);

        exitButton = new JButton("Exit");
        exitButton.setHorizontalAlignment(JButton.CENTER);

        salesPanel.add(hl);//,BorderLayout.NORTH);
        salesPanel.add(label1);//,BorderLayout.NORTH);
        // salesPanel.add(hl,BorderLayout.NORTH);
        salesPanel.add(hl);//,BorderLayout.NORTH);
        // salesPanel.add(hl,BorderLayout.WEST);

        salesPanel.add(availableModels);//,BorderLayout.EAST);
        salesPanel.add(scroll);//,BorderLayout.WEST);
        salesPanel.add(hl);//,BorderLayout.WEST);

        salesPanel.add(addAProductRadioButton);//,BorderLayout.EAST);
        salesPanel.add(removeAProductRadioButton);//,BorderLayout.EAST);
        salesPanel.add(AddFeedback);//,BorderLayout.EAST);
        salesPanel.add(topModelsRadioButton);//,BorderLayout.EAST);
        // salesPanel.add(hl,BorderLayout.EAST);
        salesPanel.add(scroll1);//,BorderLayout.EAST);
        // salesPanel.add(hl,BorderLayout.EAST);

        salesPanel.add(hl);//,BorderLayout.SOUTH);
        salesPanel.add(hl);//,BorderLayout.SOUTH);
        salesPanel.add(PurchaseButton);//, BorderLayout.SOUTH);
        salesPanel.add(hl);//,BorderLayout.SOUTH);
        salesPanel.add(exitButton);//, BorderLayout.SOUTH);

        frame.add(salesPanel);

        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.pack();

        if (user.equalsIgnoreCase("sales")) {
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
                if (res == JOptionPane.YES_OPTION) {
                    int id = Database.getId(model);
                    double total = Database.purchase(id);
                    JOptionPane.showMessageDialog(null, "Total Price : " + total + "\nThank you for the payment!");
                } else {
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

                Label l1, l2, l3, l4, l5;
                l1 = new Label("Model ID");
                l1.setBounds(50, 100, 100, 30);
                l2 = new Label("Model Name");
                l2.setBounds(50, 150, 100, 30);
                l3 = new Label("Manufacturer Name");
                l3.setBounds(50, 100, 100, 30);
                l4 = new Label("Quantity");
                l4.setBounds(50, 150, 100, 30);
                l5 = new Label("Price");
                l5.setBounds(50, 150, 100, 30);

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
                Label l1 = new Label("Model ID");
                l1.setBounds(50, 100, 100, 30);
                panel.add(l1);
                panel.add(text1);
                JOptionPane.showMessageDialog(null, panel);

                int id = Integer.parseInt(text1.getText());
                String name = Database.remove(id);

                availableModels.removeItem(name);
            }
        });
    }

    public static void main(String role) {
        user = role;
        new Sales();


    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
    }
}
