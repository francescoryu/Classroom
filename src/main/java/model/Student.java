package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter @Setter
public class Student {

    int id;
    String firstName;
    String lastName;
    String email;
    String birthday;

    int course_id;

    public Student(int id, String firstName, String lastName, String email, String birthday, int course_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.course_id = course_id;
        this.id = id;
    }

    public Student() {

    }
}
