package service;

import model.Student;

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
}
