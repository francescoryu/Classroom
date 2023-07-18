package comp.buttons;

import javax.swing.*;
import java.awt.*;

public class SecondaryButton extends JButton {
    public SecondaryButton(String text) {
        this.setText(text);
        this.setFont(new Font("", Font.PLAIN, 15));
        this.setOpaque(true);
        this.setBorderPainted(false);
    }
}
