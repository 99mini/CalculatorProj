import java.util.ArrayList;
import java.util.Scanner;

public class Listener {
    private String expression;

    public void setExpression() {
        Scanner sc = new Scanner(System.in);
        this.expression = sc.next();
    }

    public String getExpression() {
        return this.expression;
    }

    //String to ArrayList
    public ArrayList<String> change(String expression) {
        int size = expression.length();
        ArrayList<String> expressionArr = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int digit = 0;
            char tmp = expression.charAt(i);
            if (tmp >= '0' && tmp <= '9') {
                while (i + 1 < size) {
                    if (expression.charAt(i + 1) >= '0' && expression.charAt(i + 1) <= '9') {
                        i++;
                        digit++;
                    } else {
                        break;
                    }
                }
                String subString = expression.substring(i - digit, i + 1);
                expressionArr.add(subString);
            } else {
                expressionArr.add(Character.toString(tmp));
            }
        }
        return expressionArr;
    }
}
