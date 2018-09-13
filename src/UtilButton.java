import javax.swing.*;

public class UtilButton extends JButton {
    public enum UTILITY_TYPE{EQUALS,CLEAR,M_PLUSS,M_MINUS}

    public UTILITY_TYPE getType() {
        return type;
    }

    public UTILITY_TYPE type;


    public UtilButton(UTILITY_TYPE type){
        super();
        this.type=type;
        switch(type){

            case EQUALS:
                this.setText("=");
                break;
            case CLEAR:
                this.setText("CLEAR");
                break;
            case M_PLUSS:
                this.setText("M+");
                break;
            case M_MINUS:
                this.setText("M-");
                break;
        }
    }


}
