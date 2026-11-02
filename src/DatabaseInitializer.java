import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializeDatabase() {
        String scriptPath = "schemas.sql"; 
        StringBuilder sqlContent = new StringBuilder();
        
        // 1. Read the schema.sql file
        try (BufferedReader br = new BufferedReader(new FileReader(scriptPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().startsWith("--")) {
                    sqlContent.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Could not find or read schema.sql in your project folder!");
            e.printStackTrace();
            return;
        }

        // 2. Connect using YOUR class name (database) and run the script
        try (Connection conn = database.getConnection(); // <--- Calls your Class 1!
             Statement stmt = conn.createStatement()) {
            
            if (conn != null) {
                stmt.execute(sqlContent.toString());
                System.out.println("PostgreSQL tables successfully initialized in SIMS database!");
            }
            
        } catch (SQLException e) {
            System.err.println("Error running the database initialization script.");
            e.printStackTrace();
        }
    }
}
