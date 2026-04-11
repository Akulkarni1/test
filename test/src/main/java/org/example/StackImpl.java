package org.example;

import java.util.Stack;

public class StackImpl {
    public static void main(String[]args){
        //Stack<Character> stack = new Stack<>();
        String s ="()(()";
        int count = getCount(s);
        System.out.println(count*2);
    }

    private static int getCount(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            else if(!stack.isEmpty()&&s.charAt(i)==')'){
                count++;
                stack.pop();
            }
        }
        return count;
    }
}
