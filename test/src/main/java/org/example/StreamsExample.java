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
//    public List<Integer> reverse(){
//        List<Integer> list= List.of(2,3,4,5,7,6,8);
//        int count = Math.toIntExact(list.stream().count());
//        list.get(count/2);
//    }
}