import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout extends JFrame {

//    GridLayout layout = new GridLayout(0, 4);

    JTextField textfield;

    private JButton button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9, buttonEquals, buttonComma;

    public Layout(String name) {
        super(name);
        super.setLayout(new GridLayout(0,1));
        setResizable(true);
    }

    public void addComponentsToPane(final Container pane) {
//        final JPanel components = new JPanel();
//        components.setLayout(layout);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Add buttons
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(textfield = new JTextField(3), gbc);
//        pane.add(new JSeparator(), BorderLayout.CENTER);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(button1 = new JButton("1"));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(button2 = new JButton("2"));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(button3 = new JButton("3"));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(button4 = new JButton("4"));
        panel.add(button5 = new JButton("5"));
        panel.add(button6 = new JButton("6"));
        panel.add(button7 = new JButton("7"));
        panel.add(button8 = new JButton("8"));
        panel.add(button9 = new JButton("9"));
        panel.add(buttonComma = new JButton(","));
        panel.add(button0 = new JButton("0"));
        panel.add(buttonEquals = new JButton("="));

        // actionlistener


        pane.add(panel, BorderLayout.NORTH);
    }
}
