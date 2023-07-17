package view;

import controller.CourseController;
import model.Course;
import service.DatabaseConnector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingUtilities.updateComponentTreeUI;

public class Dashboard {

    JFrame mainFrame;
    JPanel selectionPanel;
    JLabel welcomeLabel;
    JButton continueButton;
    JComboBox<String> courseSelection;
    ArrayList<ArrayList<String>> courses;
    CourseController courseController = new CourseController();
    public Dashboard() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        try {
            courses = courseController.allCourses();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        courseSelection = new JComboBox<>();
        courseSelection.setFont(new Font("", Font.PLAIN, 20));
        courseSelection.setBackground(Color.decode("#FFFCF7"));
        Dimension maxDimension = new Dimension(200, courseSelection.getPreferredSize().height);
        courseSelection.setMaximumSize(maxDimension);

        for (ArrayList<String> course : courses) {
            courseSelection.addItem(course.get(1));
        }

        welcomeLabel = new JLabel("Welcome!");
        welcomeLabel.setFont(new Font("", Font.BOLD, 20));
        welcomeLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        continueButton = new JButton("Continue");
        continueButton.setFont(new Font("", Font.PLAIN, 15));

        selectionPanel = new JPanel();
        selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.Y_AXIS));
        selectionPanel.setBackground(Color.decode("#C2D8B9"));
        selectionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        selectionPanel.add(courseSelection, BorderLayout.CENTER);

        mainFrame = new JFrame("Course Selection");
        mainFrame.add(welcomeLabel, BorderLayout.NORTH);
        mainFrame.add(selectionPanel, BorderLayout.CENTER);
        mainFrame.add(continueButton, BorderLayout.SOUTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 300);
        mainFrame.setVisible(true);
    }
}
