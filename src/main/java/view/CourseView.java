package view;

import comp.buttons.SecondaryButton;
import comp.labels.TitleLabel;
import controller.StudentController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseView extends JFrame {

    ArrayList<ArrayList<String>> students;
    JPanel studentOverviewPanel;
    JPanel informationPanel;
    JLabel courseLabel;
    JLabel overViewLabel;
    public CourseView(String course) throws SQLException, ClassNotFoundException {
        StudentController studentController = new StudentController();
        students = studentController.allStudentsByCourse(course);

        courseLabel = new TitleLabel(course);
        courseLabel.setHorizontalAlignment(SwingConstants.CENTER);

        studentOverviewPanel = new JPanel();
        studentOverviewPanel.setLayout(new GridLayout(students.size() + 1, 1));
        studentOverviewPanel.setBorder(new EmptyBorder(10, 5, 10, 5));
        studentOverviewPanel.add(courseLabel);

        JScrollPane studentScrollPane = new JScrollPane(studentOverviewPanel);
        studentScrollPane.setPreferredSize(new Dimension(300, 100));
        //studentScrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        for (ArrayList<String> student : students) {
            JButton studentButton = new JButton(student.get(1) + " " + student.get(2));
            studentButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            studentButton.setPreferredSize(new Dimension(studentButton.getPreferredSize().width, 50));
            studentOverviewPanel.add(studentButton);
        }

        overViewLabel = new TitleLabel("Overview");

        informationPanel = new JPanel();
        informationPanel.add(overViewLabel);

        this.add(informationPanel, BorderLayout.NORTH);
        this.add(studentScrollPane, BorderLayout.WEST);
        this.setResizable(false);
        this.pack();
        this.setSize(800, 800);
        this.setVisible(true);
    }
}
