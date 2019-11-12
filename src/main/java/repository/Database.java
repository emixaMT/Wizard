package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private final static String DB_URL = "jdbc:mysql://localhost:3306/spring_jdbc_quest?serverTimezone=GMT";
	private final static String DB_USER = "h4rryp0tt3r";
	private final static String DB_PASSWORD = "Horcrux4life!";
	private Connection connection;
	private static Database instance;
	
	private Database() throws SQLException {
		this.connection = DriverManager.getConnection(
	            DB_URL, DB_USER, DB_PASSWORD
	    );
	}
	
	public static Database getInstance() throws SQLException {
		return instance == null ? new Database(): instance; 
	}
	
	public Connection getConnection() {
		return this.connection;
	}
}
