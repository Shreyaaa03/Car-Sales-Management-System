
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

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

    public static void addProduct(int id, String name, String manu, int qty, double price){
        try{
            Statement stmt = con.createStatement();
            String query = "insert into models (id, model_name, manufacturer, quantity, price)"
                    +" values('"+id+"','"+name+"','"+manu+"','"+qty+"','"+price+"'); ";
            stmt.executeUpdate(query);
            String query1 = "insert into stocks (model_id, inQty, outQty) values( '"+id+"', '"+qty+"', 0);";
            stmt.executeUpdate(query1);
            addDiscount();

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

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static String remove(int model_id){
        String name = "";
        try{
            Statement stmt = con.createStatement();
            String query1 = "select model_name from models where id = '"+model_id+"';";
            String query = "delete from models where id ='"+model_id+"';";
            ResultSet rs = stmt.executeQuery(query1);
            while (rs.next()) {
                name = rs.getString(1);
            }
            stmt.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e);
        }
        return name;
    }

    public static String search(String name){
        String answer = "";
        try{
            Statement stmt = con.createStatement();
            String query = "select * from models where model_name = '"+name+"';";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                answer = "Model ID: "+rs.getString(1)+"\nModel Name: "+rs.getString(2)
                +"\nManufacturer: "+rs.getString(3)+"\nPrice: "+rs.getString(5)
                +"\nColours: "+rs.getString(6)+"\nYear of Production: "+rs.getString(7)
                +"\nSeating Capacity: "+rs.getString(8)+"\nTransmission: "+rs.getString(9)
                +"\nMileage: "+rs.getString(10);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return answer;
    }

    public static int getId(String name){
        int answer = 0;
        try{
            Statement stmt = con.createStatement();
            String query = "select * from models where model_name = '"+name+"';";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                answer = rs.getInt(1);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return answer;
    }

    public static void feedback(int ch){
        try{

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

                String query1 = "insert into customers (cust_id, custName) values ('"+custid+"', '"+custname+"');";
                stmt.executeUpdate(query1);

                String query = "insert into customer_feedback"
                        +" values('"+custid+"','"+custname+"','"+agent+"','"+rate1+"','"+rate2+"', '"+complaints1+"', '"+feedback1+"'); ";
                stmt.executeUpdate(query);
                System.out.println("Thank you for your feedback!");
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

    public static double purchase(int mId){
        double price = 0;
        try{
            Statement stmt = con.createStatement();
            String query1 = "update models set quantity = quantity - 1 where id = '"+mId+"' and quantity>0;";
            String query2 = "update stocks set outQty = outQty + 1 where model_id = '"+mId+"' and inQty-outQty > 0;";
            String query3 = "select model_name, new_price from models where id = '"+mId+"';";
            ResultSet rs = stmt.executeQuery(query3);
            if (rs.next()){
                price =rs.getDouble(2);
                    stmt.executeUpdate(query1);
                    stmt.executeUpdate(query2);
            }

        } catch (Exception e){
            System.out.println(e);
        }
        return price;
    }

    public static Vector<String> topModels(){
        String answer = "";
        Vector<String> result = new Vector();
        try{
            String query ="select model_id, model_name, outQty from stocks s, models m where s.model_id=m.id order by outQty desc limit 5;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
               answer = ("\n"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
               result.add(answer);
            }

        }catch (Exception e){
            System.out.print(e);
        }
        return result;
    }

    public static void Customers(int cId, int mId, String name){
        try{
            String query ="insert into customers (cust_id, model_id, custName) values ('"+cId+"', '"+mId+"', '"+name+"');";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Inserted!");
            String query1 = "select * from customers where cust_id= '"+cId+"';";
            ResultSet rs = stmt.executeQuery(query1);
            while (rs.next()){
                System.out.println("Transaction ID : " +rs.getString(1)+"\tCustomerID: "+rs.getString(2));
            }

        }catch (Exception e){
            System.out.print(e);
        }

    }


}
