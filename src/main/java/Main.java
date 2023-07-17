import controller.StudentController;
import model.Student;
import service.StudentService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*Student student = new Student();
        student.setFirstName("Francesco");
        student.setLastName("Ryu");
        student.setEmail("fra@ryu.com");
        student.setBirthday("06-01-2004");
        student.setCourse_id(1);
        StudentService.create(student);*/

        StudentController studentController = new StudentController();
        ArrayList<Object> studentData = studentController.getStudent("john@doe.com");

        if (!studentData.isEmpty()) {
            int id = (int) studentData.get(0);
            String firstName = (String) studentData.get(1);
            String lastName = (String) studentData.get(2);
            String email = (String) studentData.get(3);
            String birthday = (String) studentData.get(4);
            int courseId = (int) studentData.get(5);

            System.out.println("Student Information:");
            System.out.println("ID: " + id);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Birthday: " + birthday);
            System.out.println("Course ID: " + courseId);
        } else {
            System.out.println("Student not found.");
        }

    }
}
