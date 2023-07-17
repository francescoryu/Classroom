import controller.StudentController;
import model.Student;
import service.StudentService;
import view.Dashboard;

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
        StudentService.create(student);

        StudentController studentController = new StudentController();
        ArrayList<ArrayList<String>> students = studentController.allStudents();

        for (ArrayList<String> student : students) {

        }*/

        new Dashboard();
    }
}
