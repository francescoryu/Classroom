package view;

import comp.buttons.PrimaryButton;
import comp.buttons.SecondaryButton;
import controller.CourseController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dashboard {

    JFrame mainFrame;
    JPanel selectionPanel;
    JPanel descPanel;
    JPanel buttonPanel;
    JLabel welcomeLabel;
    JTextArea descTextArea;
    JButton continueButton;
    JButton exitButton;
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
        courseSelection.setPrototypeDisplayValue("Select Course");
        courseSelection.setFont(new Font("", Font.PLAIN, 20));
        courseSelection.setBackground(Color.decode("#FFFCF7"));
        Dimension maxDimension = new Dimension(200, courseSelection.getPreferredSize().height);
        courseSelection.setMaximumSize(maxDimension);

        for (ArrayList<String> course : courses) {
            courseSelection.addItem(course.get(1));
        }

        descTextArea = new JTextArea();
        descTextArea.setLineWrap(true);
        descTextArea.setEnabled(false);
        descTextArea.setDisabledTextColor(Color.BLACK);
        descTextArea.setFont(new Font("Serif", Font.PLAIN, 15));

        JScrollPane descScrollPane = new JScrollPane(descTextArea);
        descScrollPane.setPreferredSize(new Dimension(250, 300));

        courseSelection.addActionListener(e -> {
            try {
                String desc = (String) courseController.getOneFromName((String) courseSelection.getSelectedItem()).get(2);
                descTextArea.setText(desc);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        welcomeLabel = new JLabel("Welcome!");
        welcomeLabel.setFont(new Font("", Font.BOLD, 20));
        welcomeLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        continueButton = new PrimaryButton("Continue");
        exitButton = new SecondaryButton("Exit");

        exitButton.addActionListener(e -> mainFrame.dispose());

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#C2D8B9"));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttonPanel.add(exitButton, BorderLayout.CENTER);
        buttonPanel.add(continueButton, BorderLayout.CENTER);

        selectionPanel = new JPanel();
        selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.Y_AXIS));
        selectionPanel.setBackground(Color.decode("#C2D8B9"));
        selectionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        selectionPanel.add(courseSelection, BorderLayout.CENTER);

        descPanel = new JPanel();
        descPanel.setPreferredSize(new Dimension(250, 300));
        descPanel.setLayout(new BorderLayout());
        descPanel.add(descScrollPane, BorderLayout.CENTER);

        mainFrame = new JFrame("Course Selection");
        mainFrame.add(welcomeLabel, BorderLayout.NORTH);
        mainFrame.add(selectionPanel, BorderLayout.CENTER);
        mainFrame.add(descPanel, BorderLayout.EAST);
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);
        mainFrame.setResizable(false);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 300);
        mainFrame.setVisible(true);
    }
}
