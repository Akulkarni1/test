package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeApp {
    //Leetcode 239 problem
    public static int[] maxSlidingWindow(int[]arr, int k){
        int n = arr.length;
        if(n==0||k>n){
            return new int [0];
        }
        int[]result = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(deque.isEmpty()&&deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            while(!deque.isEmpty()&&arr[deque.peekLast()]<=arr[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i>=k-1){
                result[i-k+1]=arr[deque.peekFirst()];
            }
        }
        return result;
    }
}
