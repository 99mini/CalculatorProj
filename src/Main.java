public class Main {
    public static void main(String[] args) {
        Listener listener = new Listener();
        Calculate calculate = new Calculate();

        String expression = new String();
        double result;

        listener.setExpression();
        expression = calculate.transform(listener.getExpression());

        result = calculate.calcFunc(expression);

        System.out.println(result);
    }
}