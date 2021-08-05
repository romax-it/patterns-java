package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {
    private static volatile DbSingleton instance = null;
    private static volatile Connection conn;

    private  DbSingleton () {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(conn != null){
            throw new RuntimeException("Use getCOnnection() method to create");
        }
        if(instance != null){
            throw new RuntimeException("Use getCOnnection() method to create");
        }
    }

    public static DbSingleton getInstance(){
        synchronized (DbSingleton.class){
            if( instance == null){
                instance = new DbSingleton();
            }
        }
        return instance;
    }

    public Connection getCOnnection(){
        if(conn == null){
            synchronized (DbSingleton.class){
                if(conn == null) {
                    try {
                        //String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
                        String dbUrl = "jdbc:postgresql://127.0.0.1:5432/logogenial_bd", "romerito-admin", "f4ast3rv3rs10n*";
                        conn = DriverManager.getConnection(dbUrl);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return conn;
    }

}
