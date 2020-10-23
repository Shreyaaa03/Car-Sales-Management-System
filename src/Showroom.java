import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class Showroom {
    private JPanel salesPanel;
    private JComboBox availableModels;
    private JTextArea specs;
    private JRadioButton addAProductRadioButton;
    private JRadioButton removeAProductRadioButton;
    private JRadioButton customerRatingRadioButton;
    private JTextArea topModels;
    private JButton purchaseButton;
    private JRadioButton topModelsRadioButton;
    private static JMenu menu;
    private static JMenuBar menubar;
    private static JMenuItem m1, m2, m3;

    public static String user = "";


    public Showroom() {

        salesPanel = new JPanel();
        salesPanel.setLayout(new GridBagLayout());
        salesPanel.setMaximumSize(new Dimension(500, 500));
        salesPanel.setMinimumSize(new Dimension(500, 500));
        salesPanel.setPreferredSize(new Dimension(500, 500));
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        salesPanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        salesPanel.add(spacer2, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("WELCOME");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 20, 0);
        salesPanel.add(label1, gbc);
        availableModels = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Models");
        defaultComboBoxModel1.addElement("Audi A8");
        defaultComboBoxModel1.addElement("Range Rover");
        defaultComboBoxModel1.addElement("Land Cruiser");
        availableModels.setModel(defaultComboBoxModel1);
        availableModels.setPreferredSize(new Dimension(120, 40));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 15, 10);
        salesPanel.add(availableModels, gbc);
        final JScrollPane scrollPane1 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 6;
        gbc.fill = GridBagConstraints.BOTH;
        salesPanel.add(scrollPane1, gbc);
        specs = new JTextArea();
        specs.setColumns(15);
        specs.setMinimumSize(new Dimension(5, 17));
        specs.setRequestFocusEnabled(false);
        specs.setRows(10);
        specs.setWrapStyleWord(true);
        scrollPane1.setViewportView(specs);
        final JScrollPane scrollPane2 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.gridheight = 5;
        gbc.fill = GridBagConstraints.BOTH;
        salesPanel.add(scrollPane2, gbc);
        topModels = new JTextArea();
        topModels.setColumns(10);
        topModels.setMinimumSize(new Dimension(5, 17));
        topModels.setRows(5);
        topModels.setWrapStyleWord(true);
        scrollPane2.setViewportView(topModels);
        final JLabel label2 = new JLabel();
        label2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        salesPanel.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        salesPanel.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        salesPanel.add(label4, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        salesPanel.add(label5, gbc);
        topModelsRadioButton = new JRadioButton();
        topModelsRadioButton.setText("Top Models");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 15, 10);
        salesPanel.add(topModelsRadioButton, gbc);
        customerRatingRadioButton = new JRadioButton();
        customerRatingRadioButton.setText("Customer Rating");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 15, 10);
        salesPanel.add(customerRatingRadioButton, gbc);
        addAProductRadioButton = new JRadioButton();
        addAProductRadioButton.setText("Add a product");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 15, 10);
        salesPanel.add(addAProductRadioButton, gbc);
        removeAProductRadioButton = new JRadioButton();
        removeAProductRadioButton.setText("Remove a Product");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 12;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 15, 10);
        salesPanel.add(removeAProductRadioButton, gbc);
        final JLabel label6 = new JLabel();
        label6.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        salesPanel.add(label6, gbc);
        final JLabel label7 = new JLabel();
        label7.setText("             ");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        salesPanel.add(label7, gbc);
        final JLabel label8 = new JLabel();
        label8.setText("      ");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        salesPanel.add(label8, gbc);
        final JLabel label9 = new JLabel();
        label9.setText("      ");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        salesPanel.add(label9, gbc);
        purchaseButton = new JButton();
        purchaseButton.setText("Purchase");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 10, 0, 10);
        salesPanel.add(purchaseButton, gbc);
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(addAProductRadioButton);
        buttonGroup.add(removeAProductRadioButton);
        buttonGroup.add(topModelsRadioButton);
        buttonGroup.add(customerRatingRadioButton);

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
        topModelsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> topProducts = Database.topModels();
                topModels.setText("Model ID\tModelName\tOrders\n");
                for (String i : topProducts) {
                    topModels.append(i);
                }
            }
        });
        customerRatingRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double rate = Database.findAvg();
                JOptionPane.showMessageDialog(null, "Average Customer Rating : " + rate);
            }
        });
        purchaseButton.addActionListener(new ActionListener() {
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

    }

    public static void main() {
        user = Client.role;
        JFrame frame = new JFrame("Showroom");
        frame.setContentPane(new Showroom().salesPanel);

        menubar = new JMenuBar();
        menu = new JMenu("Menu");
        m1 = new JMenuItem("Login");
        m2 = new JMenuItem("Feedback");
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
                Feedback.main();
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
