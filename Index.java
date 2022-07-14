
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.*;
public class Index{

    public static void main(String args[]){
        //step 1: Load the driver
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
            
            //step 2:Creating copnnection
            String url="jdbc:mysql://localhost:3306/dbone";
            String userName="root";
            String password="";
            Connection con = DriverManager.getConnection(url,userName,password);
            
            //step 3 Build a Query for Inserting data 
            String insertquery="INSERT INTO info(name,age,gender) VALUES('abc',765,'male')";
            Statement stmt=con.createStatement();
            int rows= stmt.executeUpdate(insertquery);
            
            //step 4: processing the result
            System.out.println("No of rows affected ="+rows);
            
            //step 5 Build a Query for selecting data 
            String selectquery="SELECT * FROM info";
            
            ResultSet rs = stmt.executeQuery(selectquery);
                
            while(rs.next()){
                String name= rs.getString(1); //rs.getInt("name")
                int age = rs.getInt(2);
                String gender = rs.getString(3);
                
                System.out.println("Name is"+name+"Age is"+age+"gender is"+gender);
                
                
            }
            
            
            
                
                
                
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }

}