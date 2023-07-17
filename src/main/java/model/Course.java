package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    String courseName;
    String courseDesc;

    int teacher_id;

    public Course(String courseName, String courseDesc, int teacher_id) {
        this.courseName = courseName;
        this.courseDesc = courseDesc;
        this.teacher_id = teacher_id;
    }
}
