import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CalculatorFrame extends JFrame implements ActionListener{

    private JPanel numberPanel;
    private JPanel operatorPanel;
    private JPanel utilPanel;
    private JPanel container;
    private List<JButton> numberButtons = new ArrayList<>();
    private List<JButton> operatorButtons = new ArrayList<>();
    private List<JButton>   utilButtons =   new ArrayList<>();
    private JTextField screen = new JTextField();
    private CalculatorBrain calcBrain= new CalculatorBrain();


    private final short WIDTH_CONST =350;
    private final short HEIGHT_CONST =450;

    public CalculatorFrame(){
        setSize(WIDTH_CONST,HEIGHT_CONST);
        setResizable(false);
        setTitle("Calculator 2018");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Create Components
        createButtons();
        setLayout();

        setVisible(true);
        screen.setText("0");
        screen.setPreferredSize(new Dimension(350,100));
        screen.setBackground(Color.GRAY);
        screen.setHorizontalAlignment(JTextField.CENTER);
    }

    public void setLayout(){

        container = new JPanel();
        container.setLayout(new GridBagLayout());
        container.setBackground(Color.DARK_GRAY);

        numberPanel = new JPanel(new GridBagLayout());
        numberPanel.setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7,7,7,7);
        gbc.gridx = 0;
        gbc.gridy = 0;
        numberPanel.add(numberButtons.get(2),gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        numberPanel.add(numberButtons.get(1),gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        numberPanel.add(numberButtons.get(0),gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        numberPanel.add(numberButtons.get(5),gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        numberPanel.add(numberButtons.get(4),gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        numberPanel.add(numberButtons.get(3),gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        numberPanel.add(numberButtons.get(8),gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        numberPanel.add(numberButtons.get(7),gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        numberPanel.add(numberButtons.get(6),gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        numberPanel.add(numberButtons.get(9),gbc);


        operatorPanel = new JPanel(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        operatorPanel.setBackground(Color.DARK_GRAY);
        g.insets = new Insets(7,7,7,7);
        for(int i = 0; i < operatorButtons.size(); i++){
            JButton but = operatorButtons.get(i);
            but.setBackground(Color.getHSBColor(0.7f, 0.4f, 0.8f));
            but.setVisible(true);
            g.gridy = 0;
            g.gridx = i;
            operatorPanel.add(but,g);
        }

        utilPanel = new JPanel(new GridBagLayout());
        utilPanel.setBackground(Color.DARK_GRAY);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(1,1,1,1);
        for(int i = 0; i< utilButtons.size(); i++) {
            JButton but = utilButtons.get(i);
            but.setBackground(Color.LIGHT_GRAY);
            but.setVisible(true);
            c.gridy = 0;
            c.gridx = i;
            utilPanel.add(but,c);
        }


        screen.setText("Calculator Loading...");
        Font font = new Font("SansSerif",Font.BOLD,20);
        screen.setFont(font);


        GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        container.add(screen, cons);
        cons.gridx = 0;
        cons.gridy = 1;
        container.add(utilPanel, cons);
        cons.gridx = 0;
        cons.gridy = 2;
        container.add(operatorPanel, cons);
        cons.gridx = 0;
        cons.gridy = 3;
        container.add(numberPanel, cons);

        this.add(container);
    }

    public void createButtons(){
        // Numbers 0-9
        JButton button;
        for(int i=9;i>=0;i--){
            button= new NumberButton(Integer.toString(i));
            button.addActionListener(this);
            button.setBackground(Color.GRAY);
            numberButtons.add(button);
        }

        OperatorButton.OPERATOR_TYPE[] operatorValues= OperatorButton.OPERATOR_TYPE.values();
        for (OperatorButton.OPERATOR_TYPE type:operatorValues){
            button = new OperatorButton(type);
            button.addActionListener(this);
            operatorButtons.add(button);

        }

        UtilButton.UTILITY_TYPE[] utilValues    =   UtilButton.UTILITY_TYPE.values();
        for(UtilButton.UTILITY_TYPE type:utilValues){
            button = new UtilButton(type);
            button.addActionListener(this);
            utilButtons.add(button);
        }

        // + - / *

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (source instanceof JButton){
                screen.setText(calcBrain.update((JButton) source));


        }


        screen.setHorizontalAlignment(JTextField.CENTER);
    }
}
