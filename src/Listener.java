import java.util.Scanner;

public class Listener {
    private String expression;

    public void setExpression(){
        Scanner sc = new Scanner(System.in);
        this.expression = sc.next();
    }

    public String getExpression() {
        return this.expression;
    }
}
