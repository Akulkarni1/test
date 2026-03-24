package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        int []arr = new int[8];
        arr =fillArr(arr.length);
        Arrays.stream(arr).forEach(System.out::println);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7,3,4, 8, 9);
        Set <Integer>duplicateElemenets= new HashSet();
        List elements=list.stream().filter(x->!duplicateElemenets.add(x)).collect(Collectors.toList());
        System.out.println(elements);


    }

    private static int[] fillArr(int n) {
      int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            Random rand = new Random();
            arr[i] = rand.nextInt(100);
        }
    return arr;
    }
}
