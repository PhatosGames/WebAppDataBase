package it.objectmethod.jbdc.config;
//modificato da Ivan
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/world";
	static final String USER = "root";
	static final String PASS = "root";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
