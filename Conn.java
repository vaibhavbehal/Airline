package airlinemanagementsystem;
import java.sql.*;
//
//
//
//
class Conn {
    public Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root", "Vaibhav@123");
            s = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

