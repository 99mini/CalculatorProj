import java.util.ArrayList;
import java.util.Stack;

public class Calculate {

    public ArrayList<String> pushStack(ArrayList<String> infixExpression) {
        Stack<String> stack = new Stack<>();
        int size = infixExpression.size();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String curr = infixExpression.get(i);
            if (curr.equals("(")) {
                stack.push(curr);
            } else if (curr.equals(")")) {
                while (!stack.empty()) {
                    if (!stack.peek().equals("(")) {
                        result.add(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.pop();
            } else if (curr.equals("+") || curr.equals("-")) {
                while (!stack.empty()) {
                    if (stack.peek().equals("*") || stack.peek().equals("/") || stack.peek().equals("%") || !stack.peek().equals("(")) {
                        result.add(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(curr);
            } else if (curr.equals("*") || curr.equals("/") || curr.equals("%")) {
                stack.push(curr);
            }
            //숫자인 경우
            else {
                result.add(curr);
            }
        }
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public int calcFunc(ArrayList<String> expression) {
        Stack<Integer> stack = new Stack<>();
        int size = expression.size();

        for (int i = 0; i < size; i++) {
            String curr = expression.get(i);
            if (curr.charAt(0) <= '9' && curr.charAt(0) >= '0') {
                int operand = Integer.parseInt(curr);
                stack.push(operand);
            } else {
                int operator = curr.charAt(0);
                int tmp = 0;
                int num1 = stack.pop();
                int num2 = stack.pop();

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
                stack.push(tmp);
            }
        }
        return stack.peek();
    }
}
