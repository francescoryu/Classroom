package service;

import java.sql.*;
import java.util.ArrayList;

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

    public static ArrayList<ArrayList<String>> getData(String query, Object... values) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String relativePath = "classroom.db";
        String connectionUrl = "jdbc:sqlite:" + relativePath;
        Connection conn = DriverManager.getConnection(connectionUrl);
        PreparedStatement statement = conn.prepareStatement(query);

        for (int i = 0; i < values.length; i++) {
            statement.setObject(i + 1, values[i]);
        }

        ArrayList<ArrayList<String>> resultList = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            ArrayList<String> rowData = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                String data = resultSet.getString(i);
                rowData.add(data);
            }
            resultList.add(rowData);
        }

        resultSet.close();
        statement.close();
        conn.close();

        return resultList;
    }

    public static ArrayList<Object> getSingleData(String query, String value) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String relativePath = "classroom.db";
        String connectionUrl = "jdbc:sqlite:" + relativePath;
        Connection conn = DriverManager.getConnection(connectionUrl);
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, value);
        ArrayList<Object> resultList = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        if (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                Object data = resultSet.getObject(i);
                resultList.add(data);
            }
        }

        resultSet.close();
        statement.close();
        conn.close();

        return resultList;
    }


}
