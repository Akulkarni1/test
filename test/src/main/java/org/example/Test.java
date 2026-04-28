package org.example;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        String[] s = new String[]{"2", "1", "+", "3", "*"};
        int i = 0;
        while (i < s.length) {
            String token = s[i];
            if (token.equals("*") || token.equals("+") || token.equals("-") || token.equals("/")) {
                // The second pop is the left operand, the first pop is the right operand
                int right = stack.pop();
                int left = stack.pop();

                if (token.equals("*")) {
                    stack.push(left * right);
                } else if (token.equals("+")) {
                    stack.push(left + right);
                } else if (token.equals("-")) {
                    stack.push(left - right);
                } else if (token.equals("/")) {
                    stack.push(left / right);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
            i++; // Increment once at the end of the loop
        }


        System.out.println(stack.pop());
    }
}