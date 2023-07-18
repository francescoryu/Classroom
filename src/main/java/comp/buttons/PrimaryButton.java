package comp.buttons;

import javax.swing.*;
import java.awt.*;

public class PrimaryButton extends JButton {
    public PrimaryButton(String text) {
        this.setText(text);
        this.setFont(new Font("", Font.PLAIN, 15));
        this.setForeground(Color.white);
        this.setBackground(Color.decode("#181191"));
        this.setOpaque(true);
        this.setBorderPainted(false);
    }
}
