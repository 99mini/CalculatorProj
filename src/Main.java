import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Listener listener = new Listener();
        Calculate calculate = new Calculate();

        String expression = new String();
        ArrayList<String> list = new ArrayList<>();
        double result;

        list = listener.change(listener.getExpression());

       expression = calculate.transform(listener.getExpression());

        result = calculate.calcFunc(expression);

        System.out.println(result);
    }
}