
package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionProvider {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        
          Class.forName("com.mysql.jdbc.Driver");
            
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/hr","web","websa");
           return conn;
        
    }
}
