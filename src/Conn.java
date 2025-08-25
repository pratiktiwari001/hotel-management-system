
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        // 5 steps for JDBC connection
        // 1) register the driver class
        // 2) Creating connection with help of connection interface object
        // 3) Create a statement with help of statement interface
        // 4) Executing mysql queries with the help of connection and statement interface
        // 5) closing connections
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // step 1
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","Pratik@1210");  // step 2
            s = c.createStatement();  // Step 3
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
