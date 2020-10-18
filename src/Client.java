import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
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
    private  JButton loginButton;
    private JLabel msg;

    static String username;
    static char[] password;
    static String role;


    public Client() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = textField1.getText();
                password = passwordField1.getPassword();
                credentials();
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

    /*public static void welcome(){
        System.out.println("-- WELCOME --");
        int option;
        boolean run = true;

        try {
            while (run) {
                System.out.println("1. Login \n2. Exit");
                option = sc.nextInt();
                switch (option){
                    case 1: System.out.println("\nEnter the username: ");
                        String username = sc.next();
                        out.writeUTF(username + "\n");

                        System.out.println("\nEnter the password: ");
                        String pass = sc.next();
                        out.writeUTF(pass + "\n");

                        String temp_role = in.readUTF();
                        String role = temp_role.trim();
                        if (role.equalsIgnoreCase("sales") || role.equalsIgnoreCase("admin") ) {
                            System.out.println("Login Successful!");
                            View(role);
                        }
                        else {
                            System.out.println("Wrong username or password. Try again!");
                        }
                        break;
                    case 2: run = false;
                        System.out.println("Thank you! Have a nice day!");
                        break;
                    default: System.out.println("Invalid Option");
                }

            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

     */

    public void credentials(){
        try {
            Socket client = new Socket("localhost", 8901);
            //System.out.println("Connected: " + client.getInetAddress() + " : " + client.getPort());
            out = new DataOutputStream(client.getOutputStream());
            in = new DataInputStream(client.getInputStream());

            out.writeUTF(username + "\n");
            out.writeUTF(String.valueOf(password) + "\n");
            String temp_role = in.readUTF();
            role = temp_role.trim();
            if (role.equalsIgnoreCase("sales") || role.equalsIgnoreCase("admin") ) {
                //JOptionPane.showMessageDialog(null,"Login Successful!");
                //View(role);

            }
            else {
                JOptionPane.showMessageDialog(null, "Wrong username or password. Try again!");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void View(String role1) throws Exception{
        System.out.println("[ " + role1 + " ]");
        int privilege =1;
        if (role1.equalsIgnoreCase("SALES")){
            privilege =2;
        }
        int opt =0;
        do{
            System.out.println("\n1. Show available models");
            System.out.println("2. Add a product");
            System.out.println("3. Modify the database");
            System.out.println("4. Remove a product");
            System.out.println("5. Search for a model");
            System.out.println("6. Purchase");
            System.out.println("7. View or Add Feedback from Customer");
            System.out.println("8. Display top 5 models ");
            System.out.println("9. Exit");
            opt = sc.nextInt();
            switch(opt){
                case 1: Database.displayModels();
                    break;
                case 2: if (privilege == 2){
                    System.out.println("Access denied : Only Admin can add a product!");
                }
                else{
                    Database.addProduct();
                    Database.addDiscount();
                }
                    break;
                case 3:
                    Database.addDiscount();

                    break;
                case 4: if (privilege == 2){
                    System.out.println("Access denied : Only Admin can add a product!");
                }
                else{
                    Database.remove();
                }
                    break;
                case 5: Database.search();
                    break;
                case 6:
                    System.out.println("Enter model id: ");
                    int modelId = sc.nextInt();
                    Database.purchase(modelId);

                    break;
                case 7: System.out.println("\n1. Display feedback \t2. Add a feedback");
                    int ch = sc.nextInt();
                    Database.feedback(ch);
                    break;
                case 8: Database.topModels();
                    break;

            }

        } while (opt != 9);

    }

}
