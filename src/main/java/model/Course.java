package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    String courseName;
    String courseDesc;

    public Course(String courseName, String courseDesc) {
        this.courseName = courseName;
        this.courseDesc = courseDesc;
    }
}
