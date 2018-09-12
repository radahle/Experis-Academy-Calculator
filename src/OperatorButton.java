import javax.swing.*;

public class OperatorButton extends JButton {

    public enum OPERATOR_TYPE{ADD,MULTIPLY,SUBTRACT,DIVIDE}

    OPERATOR_TYPE type;

    public OperatorButton(OPERATOR_TYPE type){
        super();
        this.type=type;

        switch (type){

            case ADD:
                this.setText("+");
                break;
            case MULTIPLY:
                this.setText("*");
                break;
            case SUBTRACT:
                this.setText("-");
                break;
            case DIVIDE:
                this.setText("/");
                break;
        }
    }

    public OPERATOR_TYPE getType(){
        return  this.type;
    }
}
