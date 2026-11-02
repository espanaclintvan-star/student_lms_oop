	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

public class database {
	
	    // Database credentials
	    private static final String URL = "jdbc:postgresql://localhost:5432/SIMS"; // Replace with your DB name
	    private static final String USER = "postgres"; // Your PostgreSQL username
	    private static final String PASSWORD = "1234"; // Your PostgreSQL password

	    public static Connection getConnection() throws SQLException {
	        try {
	            // Optional for modern Java, but explicitly loads the driver
	            Class.forName("org.postgresql.Driver"); 
	        } catch (ClassNotFoundException e) {
	            System.err.println("PostgreSQL JDBC Driver not found!");
	            e.printStackTrace();
	        }
	        
	        // Establish and return the connection
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }

}
