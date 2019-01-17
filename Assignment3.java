import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Assignment3 {

  public static Connection getConnection() throws Exception {
  try {
    String url = "jdbc:mysql://localhost:3306/sqlandjava?serverTimezone=UTC";
    String username = "user";
    String password = "password";

    Connection conn = DriverManager.getConnection(url, username, password);
    System.out.println("Connected to database!");
    return conn;
  } catch (Exception e) {System.out.println(e);}
  return null;
  }
  public static void main (String[] args) {
  }
}