import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
  public static void main (String[] args) throws Exception{
    Connection conn = getConnection();
    Statement statement = conn.createStatement();

    ResultSet res = statement.executeQuery("select * from owners");
    ArrayList<Owner> owners = new ArrayList<Owner>();
    while (res.next()) {
      Owner temp = new Owner();
      temp.owner_id = res.getInt("owner_id");
      temp.person_id = res.getInt("person_id");
      temp.car_id = res.getInt("car_id");
      owners.add(temp);
    }
    System.out.println(owners.size());
    
    res = statement.executeQuery("select * from people");
    ArrayList<Person> people = new ArrayList<Person>();
    while (res.next()) {
      Person temp = new Person();
      temp.person_id = res.getInt("person_id");
      temp.firstname = res.getString("firstname");
      temp.lastname = res.getString("lastname");
      people.add(temp);
    }
    System.out.println(people.size());
    
    res = statement.executeQuery("select * from cars");
    ArrayList<Car> cars = new ArrayList<Car>();
    while (res.next()) {
      Car temp = new Car();
      temp.car_id = res.getInt("car_id");
      temp.brand = res.getString("brand");
      temp.color = res.getString("color");
      cars.add(temp);
    }
    System.out.println(cars.size());

    for (int i = 0; i < owners.size(); i++) {
      int person_id = owners.get(i).person_id;
      int car_id = owners.get(i).car_id;

      Person person = people.get(person_id - 1);
      Car car = cars.get(car_id - 1);

      System.out.println(person.firstname + " " + person.lastname + " owns " +
                         car.color + " " + car.brand);
    }
    
  }
}