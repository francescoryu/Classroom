package view;

import comp.buttons.PrimaryButton;
import comp.labels.TitleLabel;
import controller.CourseController;
import controller.StudentController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseView extends JFrame {

    ArrayList<ArrayList<String>> students;
    JPanel studentOverviewPanel;
    JPanel informationPanel;
    JPanel interactionPanel;
    JPanel studentInfoPanel;
    JLabel courseLabel;
    JLabel overViewLabel;
    JButton courseButton;
    JComboBox<String> courseSelection;
    ArrayList<ArrayList<String>> courses;
    CourseController courseController = new CourseController();
    String course;

    public CourseView() {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        StudentController studentController = new StudentController();

        courseLabel = new TitleLabel(course);
        courseLabel.setHorizontalAlignment(SwingConstants.CENTER);

        studentOverviewPanel = new JPanel();
        studentOverviewPanel.setBorder(new EmptyBorder(10, 5, 10, 5));
        studentOverviewPanel.setBackground(Color.decode("#e6f7ff"));
        studentOverviewPanel.add(courseLabel);

        JScrollPane studentScrollPane = new JScrollPane(studentOverviewPanel);
        studentScrollPane.setBackground(Color.decode("#e6f7ff"));
        studentScrollPane.setBorder(null);
        studentScrollPane.setPreferredSize(new Dimension(250, 100));


        overViewLabel = new TitleLabel("Overview");

        informationPanel = new JPanel();
        informationPanel.add(overViewLabel);
        informationPanel.setLayout(new GridLayout(2, 1));

        try {
            courses = courseController.allCourses();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        courseSelection = new JComboBox<>();
        courseSelection.setPrototypeDisplayValue("Select Course");
        courseSelection.setFont(new Font("", Font.PLAIN, 15));

        for (ArrayList<String> courseName : courses) {
            courseSelection.addItem(courseName.get(1));
        }

        informationPanel.add(courseSelection);
        courseSelection.addActionListener(e -> {
            try {
                studentOverviewPanel.removeAll();
                students = studentController.allStudentsByCourse((String) courseSelection.getSelectedItem());
                studentOverviewPanel.setLayout(new BoxLayout(studentOverviewPanel, BoxLayout.Y_AXIS));

                Dimension buttonSize = new Dimension(200, 50);

                for (ArrayList<String> student : students) {
                    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    JButton studentButton = new JButton(student.get(1) + " " + student.get(2));
                    studentButton.setFont(new Font("", Font.BOLD, 12));
                    studentButton.setPreferredSize(buttonSize);
                    studentButton.setMaximumSize(buttonSize);
                    studentButton.setBackground(Color.decode("#7BE0AD"));
                    studentButton.setOpaque(true);
                    studentButton.setBorderPainted(false);

                    buttonPanel.add(studentButton);
                    buttonPanel.setBackground(Color.decode("#e6f7ff"));
                    studentOverviewPanel.add(buttonPanel);
                }

                studentOverviewPanel.revalidate();
                studentOverviewPanel.repaint();
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });


        courseButton = new PrimaryButton("More about Course");

        interactionPanel = new JPanel();
        interactionPanel.setBackground(Color.decode("#e6f7ff"));
        interactionPanel.add(courseButton, BorderLayout.NORTH);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(informationPanel, BorderLayout.NORTH);
        this.add(studentScrollPane, BorderLayout.WEST);
        this.add(interactionPanel, BorderLayout.CENTER);
        this.setResizable(false);
        this.pack();
        this.setSize(800, 800);
        this.setVisible(true);
    }
}
