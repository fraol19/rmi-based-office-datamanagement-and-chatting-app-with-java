package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//this class is a singlton class whose instance created only inside the class it self
//this is used for not cunsuming database Connection

public class DBConnector {

    private static DBConnector classinstnace = null;
    private final String DB_URL = "jdbc:mysql://localhost/remotedb2";
    private final String DB_USER = "flex";
    private final String DB_PASS = "3495";

    private Connection conn = null;

    private DBConnector() {
    }

    public static DBConnector getClassInstance() {
        if (classinstnace == null) {
            classinstnace = new DBConnector();
            return classinstnace;
        }
        return classinstnace;
    }

    public void startConnection() throws SQLException{
       if (conn == null) {
           conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);   
        }
    }
    
    public Connection getConnection() {
        return conn;
    }

    public void close() throws SQLException {
        if(conn != null){
           conn.close();
        }    
    }

}
