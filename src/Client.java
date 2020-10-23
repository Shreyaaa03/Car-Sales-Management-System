import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Client {

    private static DataOutputStream out = null;
    private static DataInputStream in = null;
    private static Scanner sc = new Scanner(System.in);
    private JPanel panel1;
    private  JTextField textField1;
    private  JPasswordField passwordField1;
    private JButton loginButton;

    static String username;
    static char[] password;
    public static String role;

    public Client() {

        JFrame frame = new JFrame("Login");

        panel1 = new JPanel(new GridLayout(7,7, 2, 10));

        JLabel label1 = new JLabel("World Motors LLC", SwingConstants.CENTER);
        label1.setBounds(150,120, 100,30);

        JLabel label3 = new JLabel("Username", SwingConstants.CENTER);
        label3.setBounds(150,120, 100,20);

        JLabel label4 = new JLabel("Password", SwingConstants.CENTER);
        label4.setBounds(150,120, 100,20);

        textField1 = new JTextField(5);
        textField1.setHorizontalAlignment(JTextField.CENTER);

        passwordField1 = new JPasswordField(10);
        passwordField1.setBounds(150,120, 100,20);
        passwordField1.setHorizontalAlignment(JPasswordField.CENTER);

        loginButton = new JButton("Login");
        loginButton.setHorizontalAlignment(JButton.CENTER);
        loginButton.setBounds(170,120, 100,20);


        panel1.add(label1);
        panel1.add(label3);
        panel1.add(textField1);
        panel1.add(label4);

        panel1.add(passwordField1);
        panel1.add(loginButton);

        frame.add(panel1);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = textField1.getText();
                password = passwordField1.getPassword();
                role = credentials();
                if ((role.equalsIgnoreCase("sales")) || (role.equalsIgnoreCase("admin"))) {
                    panel1.setVisible(false);
                    Showroom.main();
                    frame.dispose();
                }
               else{
                   JOptionPane.showMessageDialog(null, "Wrong username or password. Try again!");
                }

            }
        });

    }



    public static void main(String[] args) {
        new Client();
    }


    public String credentials(){
        try {
            Socket client = new Socket("localhost", 8901);
            out = new DataOutputStream(client.getOutputStream());
            in = new DataInputStream(client.getInputStream());

            out.writeUTF(username + "\n");
            out.writeUTF(String.valueOf(password) + "\n");
            String temp_role = in.readUTF();
            role = temp_role.trim();
            if (role.equalsIgnoreCase("sales") || role.equalsIgnoreCase("admin") ) {
                return role;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }


}
