package org.example;

import java.util.Arrays;
import java.util.Stack;

public class StackImpl {
    public static void main(String[]args){
        //Stack<Character> stack = new Stack<>();
        String s ="()(()";
        int count = getCount(s);
        int []arr = {1,2,3};
        roateArray(arr,2);
        System.out.println(count*2);
    }
    public static void roateArray(int[]arr,int count){
        for(int i=0;i<count;i++){
            int temp=arr[0];
            arr[0]=arr[arr.length-1];
            arr[arr.length-1]=temp;
        }
        System.out.println(Arrays.toString(arr));
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
