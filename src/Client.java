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
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = textField1.getText();
                password = passwordField1.getPassword();
                role = credentials();
                if ((role.equalsIgnoreCase("sales")) || (role.equalsIgnoreCase("admin"))) {
                    panel1.setVisible(false);
                    Sales.main(role);
                }
               else{
                   JOptionPane.showMessageDialog(null, "Wrong username or password. Try again!");
                }

            }
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Client");
        frame.setContentPane(new Client().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
