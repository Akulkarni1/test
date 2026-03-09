package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swap2(arr, i, j);
            }
        }

        swap2(arr, i + 1, end);

        return i+1;
    }

    private static void swap2(int[] arr, int i, int j) {
        int swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
    }

    public static void quickSort(int[]arr, int start, int end){
        if(start<end){
            int partition = partition(arr, start,end);
            quickSort(arr, start, partition-1);
            quickSort(arr, partition+1, end);
        }
    }
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int []arr = {3,4,2,1,4,7};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        System.out.printf("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}