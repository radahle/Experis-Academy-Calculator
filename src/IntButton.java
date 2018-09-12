import javax.swing.*;

public class IntButton extends JButton {

    private int integer;

    public IntButton(String integer){
        super(integer);
        this.integer=Integer.parseInt(integer);
    }

    public int getInteger(){
        return this.integer;
    }
}
