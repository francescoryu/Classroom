package controller;

import service.CourseService;
import service.StudentService;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseController {
    public ArrayList<ArrayList<String>> allCourses() throws SQLException, ClassNotFoundException {
        return CourseService.getAll();
    }
}
