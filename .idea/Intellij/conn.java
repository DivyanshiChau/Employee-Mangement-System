package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection connection;
    Statement statement;

    public conn (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeemanagement","root","Khushi@2308");
            statement = connection.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
