import model.Student;
import service.StudentService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Student student = new Student();
        student.setFirstName("Francesco");
        student.setLastName("Ryu");
        student.setEmail("fra@ryu.com");
        student.setBirthday("06-01-2004");
        student.setCourse_id(1);
        StudentService.create(student);
    }
}
