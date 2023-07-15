import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");

            URL url = SQLiteConnection.class.getClassLoader().getResource("classroom.db");

            if (url != null) {
                String filePath = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);
                File file = new File(filePath);

                String connectionUrl = "jdbc:sqlite:" + file.getAbsolutePath();
                Connection conn = DriverManager.getConnection(connectionUrl);

                if (conn != null) {
                    System.out.println("Connected to the SQLite database!");
                }

                // Close the connection
                conn.close();
            } else {
                System.out.println("Database file not found.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
