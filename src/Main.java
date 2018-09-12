import javax.swing.*;
import java.awt.*;

public class Main {

    static JTextField textfield1, textfield2, textfield3;
    public static void main(String[] args) {
        Layout layout = new Layout("Kalkulator");

//        Example layout = new Example("GridLayoutDemo");
        layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        layout.addComponentsToPane(layout.getContentPane());
        //Display the window.
        layout.pack();
        layout.setVisible(true);
    }
}
