import javax.swing.*;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame {

    JTextField input;

    JButton btn;

    Main(){

        JFrame frame = new JFrame("My First Swing Example");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        Buttons.placeComponents(panel);
        frame.setVisible(true);
    }




    public static void main(String[] args) {

        Main cal = new Main();
        cal.setVisible(true);

    }


}
