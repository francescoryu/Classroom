package service;

import model.Student;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentService {
    public static void create(Student student) throws ClassNotFoundException {
        String query = "INSERT INTO Student (firstName, lastName, email, birthday, course_id) VALUES (?, ?, ?, ?, ?)";
        DatabaseConnector.executeQuery(query,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getBirthday(),
                student.getCourse_id());
    }

    public static void delete(Student student) throws ClassNotFoundException {
        String query = "DELETE FROM Student WHERE email=?";
        DatabaseConnector.executeQuery(query,
                student.getEmail());
    }

    public static void update(Student student) throws ClassNotFoundException {
        String query = "UPDATE Student SET firstName = ?, lastName = ?, email = ?, birthday = ?, course_id = ?" +
                " WHERE id = ?";
        DatabaseConnector.executeQuery(query,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getBirthday(),
                student.getCourse_id(),
                student.getId());
    }

    public static ArrayList<Object> get(String email) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM Student WHERE email = ?";

        return DatabaseConnector.getSingleData(query, email);
    }

    public static ArrayList<ArrayList<String>> getAllByCourse(String courseName) throws ClassNotFoundException, SQLException {
        ArrayList<ArrayList<String>> students;
        String query = "SELECT s.*" +
                " FROM Student s" +
                " JOIN Course c ON s.course_id = c.id" +
                " WHERE c.courseName = ?";
        students = DatabaseConnector.getData(query, courseName);
        return students;
    }
}
