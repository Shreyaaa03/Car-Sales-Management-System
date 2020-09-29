import java.sql.*;
import java.util.Scanner;

public class Database {
    static Connection con = null;
    static String url = "jdbc:mysql://localhost:3306/carsale";
    static String username = "root";
    static String password = "password";

    static Scanner sc = new Scanner(System.in);

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static String verifyLogin(String user, String pass){
        try {
            String role="";
            Statement stmt = con.createStatement();
            String query = "select * from user_master where username = '" + user + "' and password = '" + pass + "' ;";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
               role = rs.getString(4);
            }
            return role;
        }
        catch(Exception e){
            System.out.println(e);
            return "";
        }
    }

    public static void displayModels(){
        try{
            System.out.println("\n-- AVAILABLE MODELS --");
            Statement stmt = con.createStatement();
            String query = "select model_name from models";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString(1));
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void addProduct(){
        try{
            System.out.println("\nEnter the details :");
            System.out.println("Model ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("Model Name: ");
            String name = sc.nextLine();
            System.out.println("Manufacturer Name: ");
            String manu = sc.nextLine();
            System.out.println("Quantity: ");
            int qty = Integer.parseInt(sc.nextLine());
            System.out.println("Price: ");
            double price = Double.parseDouble(sc.nextLine());

            Statement stmt = con.createStatement();
            String query = "insert into models (id, model_name, manufacturer, quantity, price)"
                    +" values('"+id+"','"+name+"','"+manu+"','"+qty+"','"+price+"'); ";
            stmt.executeUpdate(query);
            String query1 = "insert into stocks (model_id, inQty, outQty) values( '"+id+"', '"+qty+"', 0);";
            stmt.executeUpdate(query1);

            System.out.println("Inserted!");

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void addDiscount(){
        try{
            Statement stmt = con.createStatement();
            String query = "update models set new_price = price - 0.7 where price >= 140.0;";
            String query1 = "update models set new_price = price - 0.0 where price < 140.0;";
            stmt.executeUpdate(query);
            stmt.executeUpdate(query1);
            String query2 = "select model_name, price, new_price from models";
            ResultSet rs = stmt.executeQuery(query2);
            while (rs.next()){
                System.out.println("Model: "+rs.getString(1) + "\tPrice: "+ rs.getString(2) + "\tAfter Discount: "+ rs.getString(3));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void remove(){
        try{
            System.out.println("Enter the model id : ");
            int model_id = Integer.parseInt(sc.nextLine());
            Statement stmt = con.createStatement();
            String query = "delete from models where id ='"+model_id+"';";
            stmt.executeUpdate(query);
            String query2 = "select id, model_name from models";
            ResultSet rs = stmt.executeQuery(query2);
            while (rs.next()){
                System.out.println("Model ID: "+rs.getString(1)+"\tModel Name: "+rs.getString(2));
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void search(){
        try{
            System.out.println("Enter the model name : ");
            String name = sc.nextLine();
            Statement stmt = con.createStatement();
            String query = "select * from models where model_name = '"+name+"';";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                System.out.println("Model ID: "+rs.getString(1)+"\tModel Name: "+rs.getString(2)
                +"\nManufacturer: "+rs.getString(3)+"\tPrice: "+rs.getString(5)
                +"\nColours: "+rs.getString(6)+"\nYear of Production: "+rs.getString(7)
                +"\tSeating Capacity: "+rs.getString(8)+"\nTransmission: "+rs.getString(9)
                +"\tMileage: "+rs.getString(10));
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void feedback(){
        try{
            System.out.println("\n1. Display feedback \t2. Add a feedback");
            int ch = Integer.parseInt(sc.nextLine());
            Statement stmt = con.createStatement();
            if (ch == 2 ){
                System.out.println("Customer ID: ");
                int custid = Integer.parseInt(sc.nextLine());
                System.out.println("Customer Name: ");
                String custname = sc.nextLine();
                System.out.println("Agent ID: ");
                int agent = Integer.parseInt(sc.nextLine());
                System.out.println("Overall Rate (5): ");
                int rate1 = Integer.parseInt(sc.nextLine());
                System.out.println("Assistance Rate (5): ");
                int rate2 = Integer.parseInt(sc.nextLine());
                System.out.println("Complaints: ");
                String complaints1 = sc.nextLine();
                System.out.println("Other feedback: ");
                String feedback1 = sc.nextLine();

                String query = "insert into customer_feedback"
                        +" values('"+custid+"','"+custname+"','"+agent+"','"+rate1+"','"+rate2+"', '"+complaints1+"', '"+feedback1+"'); ";
                stmt.executeUpdate(query);
            }
            else if (ch == 1){
                String query2 = "select * from customer_feedback";
                ResultSet rs = stmt.executeQuery(query2);
                while (rs.next()){
                    System.out.println("Customer Name: "+rs.getString(2) + "\tOverall Rate (5): "+ rs.getString(4) + "\tAssistance Rate (5): "+ rs.getString(5) + "\tComplaints : "+ rs.getString(6));
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void purchase(){
        try{
            System.out.println("Enter model id: ");
            int mId = Integer.parseInt(sc.nextLine());
            Statement stmt = con.createStatement();
            String query1 = "update models set quantity = quantity - 1 where id = '"+mId+"' and quantity>0;";
            String query2 = "update stocks set outQty = outQty + 1 where model_id = '"+mId+"' and inQty-outQty > 0;";
            String query3 = "select model_name, new_price from models where id = '"+mId+"';";
            ResultSet rs = stmt.executeQuery(query3);
            if (rs.next()){
                System.out.println("Model : "+rs.getString(1)+"\nTotal Price = "+rs.getString(2));
                System.out.println("Confirm the payment - ");
                String payment = sc.nextLine();
                if (payment.equalsIgnoreCase("y") || payment.equalsIgnoreCase("yes")){
                    stmt.executeUpdate(query1);
                    stmt.executeUpdate(query2);
                    System.out.println("Thank you for the payment!");
                }
                else{
                    System.out.println("Payment cancelled.");
                }
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void topModels(){
        try{
            String query ="select model_id, model_name, outQty from stocks s, models m where s.model_id=m.id order by outQty desc limit 5;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Model ID\tName\t\t\tOrders");
            while (rs.next()){
                System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
            }

        }catch (Exception e){
            System.out.print(e);
        }
    }


}
