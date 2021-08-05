package singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {
    public static void main(String[] args) {
        DbSingleton instance =  DbSingleton.getInstance();
        Connection conn = instance.getCOnnection();

        Statement sta;
        try {
            sta = conn.createStatement();
            int count = sta.executeUpdate("create table Address(ID INT, StreetName VARCHAR(20), City VARCHAR (20))");
            System.out.println("Table created.");
            sta.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        long timeBefore = System.currentTimeMillis();
        conn = instance.getCOnnection();
        long timeAfter = System.currentTimeMillis();
        System.out.println(timeAfter - timeBefore);

    }
}
