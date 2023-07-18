package controller;

import service.CourseService;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseController {
    public ArrayList<ArrayList<String>> allCourses() throws SQLException, ClassNotFoundException {
        return CourseService.getAll();
    }

    public ArrayList<Object> getOneFromName(String courseName) throws SQLException, ClassNotFoundException {
        return CourseService.get(courseName);
    }
}
