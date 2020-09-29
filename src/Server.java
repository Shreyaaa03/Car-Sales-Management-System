import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Server extends Thread{

        public Scanner scanner = new Scanner(System.in);

        private DataOutputStream dataOutputStream = null;
        private DataInputStream dataInputStream = null;
        private ObjectOutputStream objectOutputStream = null;
        private ObjectInputStream objectInputStream = null;
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
           // finally{
               // System.out.println("Closed: "+clientSocket.getInetAddress()+":"+port);
             //   try {
               //     System.out.println("Closed: "+clientSocket.getInetAddress()+":"+port);
                 //   clientSocket.close();
               // }catch (IOException e){
             //       System.out.println(e);
               // }
           // }

        }

        public void login() throws Exception{
            System.out.println("Port: "+ port+ " -- Login:");
            String user = dataInputStream.readUTF();
            String username1 = user.trim();
            System.out.println("["+port+"] username: "+username1);
            String pass = dataInputStream.readUTF();
            String password1 = pass.trim();
            System.out.println("["+port+"] password: "+ "*".repeat(password1.length()));
            try{
                String check = "";
                //Class.forName("com.mysql.cj.jdbc.Driver");
                //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsale","root","password");
                //Statement stmt = con.createStatement();
                //String query = "select * from user_master where username = '"+username1+"' and password = '"+password1+"' ;";
                //ResultSet rs = stmt.executeQuery(query);
                //System.out.println("ResultSet = " + rs.getString(4));
                check = Database.verifyLogin(username1, password1);
                //while (rs.next()){
                   // System.out.println("Login Successful!");
                 //   check = rs.getString(4);

                //}
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

    public synchronized void buy() throws Exception{
        System.out.println("Port: "+ port+ " -- Purchase:");
        String id = dataInputStream.readUTF();
        int modelId = Integer.parseInt(id.trim());
/*
        try{
            System.out.println("Enter Customer ID: ");
            int custID = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Customer Name: ");
            String custName = scanner.nextLine();
            int transactionID = Database.Customers(custID, modelId, custName);
            System.out.println("Transaction ID: " + transactionID + "\tCustomer ID: "+ custID);
        }

            //dataOutputStream.writeUTF();
          //  dataOutputStream.flush();


        catch(Exception e){
            System.out.println(e);
        }

 */
    }




}
