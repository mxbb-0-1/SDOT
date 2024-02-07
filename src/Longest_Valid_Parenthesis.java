//Longest_Valid_Parentheses using Java
import java.util.Stack;
public class Longest_Valid_Parenthesis {
    public static void main(String[] args) {
        String s = "((()";
        System.out.println(longestValidParentheses(s));
    }
    private static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
