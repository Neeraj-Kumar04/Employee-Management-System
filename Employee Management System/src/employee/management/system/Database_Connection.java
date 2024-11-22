package employee.management.system;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database_Connection {

    Connection connection;
    Statement statement;

    public Database_Connection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","Neerajcoder@123");
            statement = connection.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
