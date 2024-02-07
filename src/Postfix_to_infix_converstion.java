//Postfix_to_infix_converstion using Stack
import java.util.Stack;
public class Postfix_to_infix_converstion {
    public static void main(String[] args) {
        String exp = "abc*+d-ef^gh*+i-";
        System.out.println(postfixToInfix(exp));
    }
    private static String postfixToInfix(String exp) {
        Stack<String> stack = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("(" + op2 + c + op1 + ")");
            }
        }
        return stack.pop();
    }
}
