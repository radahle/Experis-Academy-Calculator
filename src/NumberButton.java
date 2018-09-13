import javax.swing.*;

public class NumberButton extends JButton {

    private int number;

    public NumberButton(String number){
        super(number);
        this.number=Integer.parseInt(number);
    }

    public int getNumber(){
        return this.number;
    }
}
