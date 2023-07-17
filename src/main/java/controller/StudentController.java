package controller;

import service.StudentService;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentController {
    public ArrayList<Object> getStudent(String email) throws SQLException, ClassNotFoundException {
        return StudentService.get(email);
    }

    public ArrayList<ArrayList<String>> allStudentsByCourse(String courseName) throws SQLException, ClassNotFoundException {
        return StudentService.getAllByCourse(courseName);
    }
}
