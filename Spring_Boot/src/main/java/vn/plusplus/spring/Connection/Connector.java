package vn.plusplus.spring.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private Connector(){
    }
    private static Connector connector;
    public static Connector getInstance(){
        if (connector==null){
            connector=new Connector();
        }
        return connector;
    }
    public Connection getConnection(){
        Connection con=null;
        try {
            Class.forName("com.msql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysach");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
