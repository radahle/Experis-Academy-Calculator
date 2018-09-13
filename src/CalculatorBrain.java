import javax.swing.*;

public class CalculatorBrain {

    private String numberStream = new String();
    private final byte MAX_INT=9;
    private int[] numbers = new int[2];
    private int counter = 0;
    private OperatorButton.OPERATOR_TYPE lastType;
    private int memory = 0;

    public CalculatorBrain(){}

    //Main method which connects BackEnd to FrontEnd
    public String update(JButton button){
        String output = "";

        if (button instanceof IntButton){
            // check if it is a number
            if(numberStream.length()<MAX_INT) numberStream+=((IntButton) button).getInteger();
            System.out.println(counter);
            numbers[counter] = Integer.parseInt(numberStream);
            System.out.println(numbers[0] + " " +numbers[1] + " " + counter);
            output = Integer.toString(numbers[counter]);


         }
         else if (button instanceof OperatorButton){
            // Not a number then it is a string;
             // Or the number is too Large!

             numberStream="";
             output=Integer.toString(numbers[0]);

             if (counter==1){
                 calculate(lastType);
             }
             else if (counter==0){
                 counter++;
             }
            lastType=((OperatorButton) button).getType();


         } else if (button instanceof UtilButton) {
             output =   utilAction(((UtilButton) button).getType());



        }

         return output;
    }

    public void clear(){
        counter=0;
        numberStream="";
        lastType= null;
        for(int i=0;i<numbers.length;i++){
            numbers[i]=0;
        }
    }

    public int add(){
        numbers[0]=numbers[1]+numbers[0];
        numbers[1]=0;
        counter=1;
        return numbers[0];
    }

    public int multiply(){
        numbers[0]=numbers[1]*numbers[0];
        numbers[1]=0;
        counter=1;
        return numbers[0];
    }

    public int subtract(){
        numbers[0]=numbers[0]-numbers[1];
        numbers[1]=0;
        counter=1;
        return numbers[0];
    }

    public int divide(){
        numbers[0]=numbers[0]/numbers[1];
        numbers[1]=0;
        counter=1;
        return numbers[0];
    }

    public void addToMemory() {

    }

    public void subtractFromMemory() {

    }

    public void clearMemory() {

    }

    public int recallFromMemory() {
        return 0;
    }

    public int calculate(OperatorButton.OPERATOR_TYPE type){

        int output=0;

        switch (lastType){

            case ADD:
                output  =   add();
                break;
            case MULTIPLY:
                output  =   multiply();
                break;
            case SUBTRACT:
                output  =   subtract();
                break;
            case DIVIDE:
                output  =   divide();
                break;
        }

        return output;
    }

    public String utilAction(UtilButton.UTILITY_TYPE type){
        String output="";
        switch (type){

            case EQUALS:
                output = Integer.toString(calculate(lastType));
                clear();
                break;
            case CLEAR:
                clear();
                break;
            case M_PLUSS:
                addToMemory();
                break;
            case M_MINUS:
                subtractFromMemory();
                break;
            case M_CLEAR:
                clearMemory();
                break;
            case M_RECALL:
                recallFromMemory();
                break;
        }

        return output;
    }

}
