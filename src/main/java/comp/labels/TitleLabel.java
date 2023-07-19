package comp.labels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TitleLabel extends JLabel {
    public TitleLabel(String text) {
        this.setText(text);
        this.setFont(new Font("", Font.BOLD, 20));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
    }
}
