import javax.swing.*;

public class CalculatorBrain {

    private String numberStream = new String();
    private final byte MAX_INT=9;
    private float[] numbers = new float[2];
    private  int counter = 0;
    private OperatorButton.OPERATOR_TYPE lastType;
    private float memory = 0f;
    private String output = "";
    private boolean recentClear = true;

    public CalculatorBrain(){}

    //Main method which connects BackEnd to FrontEnd
    public String update(JButton button){
//        output = "";


        if (button instanceof NumberButton){
            recentClear=false;
            // check if it is a number
            if(numberStream.length()<MAX_INT) numberStream+=((NumberButton) button).getNumber();
            numbers[counter] = Float.parseFloat(numberStream);
            System.out.println(numbers[0] + " " +numbers[1] + " " + counter);
            output = Float.toString(numbers[counter]);
         }
         else if (button instanceof OperatorButton && !recentClear){
            // Not a number then it is a string;
             // Or the number is too Large!

             numberStream="";
             output=Float.toString(numbers[0]);

             if (counter==1 && lastType != null){
                 calculate(lastType);
             }
             else if (counter==0){
                 counter++;
             }
            lastType=((OperatorButton) button).getType();


         } else if (button instanceof UtilButton && !recentClear) {
             utilAction(((UtilButton) button).getType());
        }

         return output;
    }

    public void clear(){
        recentClear=true;
        counter=0;
        numberStream="";
        lastType= null;
        output="";
        for(int i=0;i<numbers.length;i++){
            numbers[i]=0;
        }
    }

    public float add(){
        numbers[0]=numbers[1]+numbers[0];
        numbers[1]=0;
        counter=1;
        return numbers[0];
    }

    public float multiply(){
        numbers[0]=numbers[1]*numbers[0];
        numbers[1]=0;
        counter=1;
        return numbers[0];
    }

    public float subtract(){
        numbers[0]=numbers[0]-numbers[1];
        numbers[1]=0;
        counter=1;
        return numbers[0];
    }

    public float divide(){
        numbers[0]=numbers[0]/numbers[1];
        numbers[1]=0;
        counter=1;
        return numbers[0];
    }

    public void addToMemory() {
        memory += Float.parseFloat(output);
    }

    public void subtractFromMemory() {
        memory -= Float.parseFloat(output);
    }

    public void clearMemory() {
        memory = 0f;
    }

    public float recallFromMemory() {
        numbers[0] = (int)memory;
        counter = 1;
        return memory;
    }

    public float calculate(OperatorButton.OPERATOR_TYPE type){

        float  output=0;

        switch (type){

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

    public void utilAction(UtilButton.UTILITY_TYPE type){
        //String output="";



        switch (type){

            case EQUALS:
                if(counter == 1) {
                    float result = calculate(lastType);
                    output = Float.toString(result);
                    numbers[0] = result;
                    numbers[1] = 0f;
                    counter = 0;
                    numberStream = "";
                    lastType = null;
                }
                break;
            case CLEAR:
                clear();
                break;
            case M_PLUSS:
                addToMemory();
                numberStream = "";
                break;
            case M_MINUS:
                subtractFromMemory();
                break;
            case M_CLEAR:
                clearMemory();
                break;
            case M_RECALL:
                output = Float.toString(recallFromMemory());
                break;
        }

        //return output;
    }

}
