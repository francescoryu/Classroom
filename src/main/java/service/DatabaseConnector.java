package service;

import org.sqlite.SQLiteConnection;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnector {
    public static void executeQuery(String query, Object... values) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            String relativePath = "classroom.db";
            String connectionUrl = "jdbc:sqlite:" + relativePath;
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = conn.prepareStatement(query);

            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
