import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Listener listener = new Listener();
        Calculate calculate = new Calculate();

        listener.setExpression();
        String expression = listener.getExpression();

        ArrayList<String> list = listener.change(expression);

        int result = calculate.calcFunc(calculate.pushStack(list));

        System.out.println(result);
    }
}