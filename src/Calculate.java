import java.util.Stack;

public class Calculate {

    public String transform(String infixExpression) {
        Stack<Character> stack = new Stack<>();
        int size = infixExpression.length();
        String result = "";

        for (int i = 0; i < size; i++) {
            if (infixExpression.charAt(i) == '(') {
                stack.push(infixExpression.charAt(i));
            } else if (infixExpression.charAt(i) == ')') {
                while (!stack.empty()) {
                    if (stack.peek() != '(') {
                        result += stack.pop();
                    } else {
                        break;
                    }
                }
                stack.pop();
            } else if (infixExpression.charAt(i) <= '9' && infixExpression.charAt(i) >= '0') {
                result += infixExpression.charAt(i);
            } else if (infixExpression.charAt(i) == '+' || infixExpression.charAt(i) == '-') {
                while (!stack.empty()) {
                    if (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '%' || stack.peek() != '(') {
                        result += stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(infixExpression.charAt(i));
            } else if (infixExpression.charAt(i) == '*' || infixExpression.charAt(i) == '/' || infixExpression.charAt(i) == '%') {
                stack.push(infixExpression.charAt(i));
            }
        }
        while (!stack.empty()) {
            result += stack.pop();
        }
        return result;
    }

    public int calcFunc(String expression) {
        Stack<Character> stack = new Stack<>();
        int size = expression.length();

        for (int i = 0; i < size; i++) {
            if (expression.charAt(i) <= '9' && expression.charAt(i) >= '0') {
                stack.push(expression.charAt(i));
            } else {
                int operator = expression.charAt(i);
                int tmp = 0;
                int num1 = Character.getNumericValue(stack.pop());
                int num2 = Character.getNumericValue(stack.pop());

                switch (operator) {
                    case '+':
                        tmp = num1 + num2;
                        break;
                    case '-':
                        tmp = num2 - num1;
                        break;
                    case '*':
                        tmp = num1 * num2;
                        break;
                    case '/':
                        tmp = num2 / num1;
                        break;
                    case '%':
                        tmp = num2 % num1;
                        break;
                    default:
                        break;
                }
                stack.push(Character.forDigit(tmp, 10));
            }
        }
        return Character.getNumericValue(stack.peek());
    }
}
