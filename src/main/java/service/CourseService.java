package service;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseService {
    public static ArrayList<ArrayList<String>> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<ArrayList<String>> courses;
        String[] courseArr;
        String query = "SELECT * FROM Course";
        courses = DatabaseConnector.getData(query);
        return courses;
    }
}
