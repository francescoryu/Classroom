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

        return DatabaseConnector.getSingeData(query, email);
    }

    public static ArrayList<ArrayList<String>> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<ArrayList<String>> students;
        String query = "SELECT * FROM Student";
        students = DatabaseConnector.getData(query);
        return students;
    }
}
