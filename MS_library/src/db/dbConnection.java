package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class dbConnection {
    protected static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/pwc_library";
    private static final String USER = "root";
    private static final String PASS = "1234";
    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.err.println("The connection was successful");
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading SQL Server JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
        }
        return connection;
    }
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
