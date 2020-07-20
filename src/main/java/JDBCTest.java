import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;

public class JDBCTest {
	
	private static List<String> getEmployeeFirstNames() {
		List<String> firstNames = new ArrayList<>();
		try {
			
			DriverManager.registerDriver(new Driver());
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
					"root",
					"codeup"
			                                                   );
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT first_name FROM employees.employees LIMIT 10");
			
			while(rs.next()) {
				firstNames.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return firstNames;
	}
	
	private static List<String> getEmployeeFirstNames(int numberOfNames) {
		List<String> firstNames = new ArrayList<>();
		try {
			
			DriverManager.registerDriver(new Driver());
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/employees?serverTimezone=UTC&useSSL=false",
					"root",
					"codeup"
			                                                   );
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT first_name FROM employees.employees LIMIT " + numberOfNames);
			
			while(rs.next()) {
				firstNames.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return firstNames;
	}
	
	public static void main(String[] args) {
		System.out.println(getEmployeeFirstNames());
		System.out.println("=========");
		System.out.println(getEmployeeFirstNames(15));
	}
}
