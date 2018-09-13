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


    private final short WIDTH_CONST =300;
    private final short HEIGHT_CONST =500;

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
        screen.setText("CLEAR");
        screen.setHorizontalAlignment(JTextField.CENTER);
    }

    public void setLayout(){
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        numberPanel = new JPanel(new GridLayout(6,3));
        for(JButton button:numberButtons){
            button.setVisible(true);
            numberPanel.add(button);
        }

        operatorPanel = new JPanel(new GridLayout(3,4));
        for(JButton button:operatorButtons){
            button.setVisible(true);
            operatorPanel.add(button);
        }

        utilPanel = new JPanel(new GridLayout(2,4));
        for(JButton button:utilButtons){
            button.setVisible(true);
            numberPanel.add(button);
        }


        screen.setText("Calculator Loading...");
        Font font = new Font("SansSerif",Font.BOLD,20);
        screen.setFont(font);


        container.add(screen);
        container.add(numberPanel);
        container.add(operatorPanel);
        container.add(utilPanel);



        this.add(container);
    }

    public void createButtons(){
        // Numbers 0-9
        JButton button;
        for(int i=0;i<10;i++){
            button= new IntButton(Integer.toString(i));
            button.addActionListener(this);
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
