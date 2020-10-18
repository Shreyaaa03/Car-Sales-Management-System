import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Server extends Thread{

        public static Scanner scanner = new Scanner(System.in);

        private static DataOutputStream dataOutputStream = null;
        private static DataInputStream dataInputStream = null;
        private static ObjectOutputStream objectOutputStream = null;
        private static ObjectInputStream objectInputStream = null;
        private Socket clientSocket = null;

        int port;

        public Server(Socket clientSocket){
            this.clientSocket = clientSocket;
        }

        @Override
        public void run(){
            try {
                port = clientSocket.getPort();
                System.out.println("Connected: "+clientSocket.getInetAddress()+":"+port);
                dataInputStream = new DataInputStream(clientSocket.getInputStream());
                dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

               Scanner sc = new Scanner(clientSocket.getInputStream());

                login();


            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void login() throws Exception{
            System.out.println("Port: "+ port+ " -- Login:");
            String user = dataInputStream.readUTF();
            String username1 = user.trim();
            System.out.println("["+port+"] username: "+username1);
            String pass = dataInputStream.readUTF();
            String password1 = pass.trim();
            System.out.println("["+port+"] password: "+ password1+ "*".repeat(password1.length()));
            try{
                String check = "";
                check = Database.verifyLogin(username1, password1);
                if (check.length() == 0){
                    System.out.println("Failed!");
                }
                else{
                    System.out.println("Login Successful!");
                }
                dataOutputStream.writeUTF(check + "\n");
                dataOutputStream.flush();

            }
            catch(Exception e){
                System.out.println(e);
            }
        }

    public static synchronized void buy(int modelId) {

        try{
            System.out.println("Enter Customer ID: ");
            int custID = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Customer Name: ");
            String custName = scanner.nextLine();
            Database.Customers(custID, modelId, custName);

        }

        catch(Exception e){
            System.out.println(e);
        }


    }

}
