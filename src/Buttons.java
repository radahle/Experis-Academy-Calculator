import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons implements ActionListener {

    public static void placeComponents(JPanel panel) {

        /* We will discuss about layouts in the later sections
         * of this tutorial. For now we are setting the layout
         * to null
         */
        panel.setLayout(null);

        JTextField input = new JTextField();
        input.setBounds(10 ,10 , 200 , 25);
        panel.add(input);

        JButton one = new JButton("1");
        one.setBounds(10, 50, 50, 25);
        panel.add(one);
        one.addActionListener(oneFunction);

        JButton two = new JButton("2");
        two.setBounds(70, 50, 50, 25);
        panel.add(two);

        JButton three = new JButton("3");
        three.setBounds(130, 50, 50, 25);
        panel.add(three);

        JButton four = new JButton("4");
        four.setBounds(190, 50, 50, 25);
        panel.add(four);

        JButton zad = new JButton("+");
        zad.setBounds(250, 50, 50, 25);
        panel.add(zad);


        JButton five = new JButton("5");
        five.setBounds(10, 90, 50, 25);
        panel.add(five);

        JButton six = new JButton("6");
        six.setBounds(70, 90, 50, 25);
        panel.add(six);

        JButton seven = new JButton("7");
        seven.setBounds(130, 90, 50, 25);
        panel.add(seven);

        JButton eight = new JButton("8");
        eight.setBounds(190, 90, 50, 25);
        panel.add(eight);

        JButton nas = new JButton("-");
        nas.setBounds(250, 90, 50, 25);
        panel.add(nas);


        JButton nine = new JButton("9");
        nine.setBounds(60, 125, 50, 25);
        panel.add(nine);

        JButton zero = new JButton("0");
        zero.setBounds(120, 125, 50, 25);
        panel.add(zero);

        JButton dote = new JButton(".");
        dote.setBounds(180, 125, 50, 25);
        panel.add(dote);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

      if (e.getSource() == oneFunction()) {
          System.out.println("Hello Man Tou Made Smartass ...!");
      }

    }




    public static String oneFunction(){

    }
}
