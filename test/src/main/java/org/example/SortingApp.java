package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class QuickSortStream{
    public List<Integer> quickSort(List<Integer> list){
        int pivot;
        if(list.isEmpty()){
            return list;
        } else{
            pivot=list.get(list.size()/2);
           List<Integer> left= list.stream().filter(x->x<pivot).collect(Collectors.toList());
           List<Integer> middle = list.stream().filter(x->x==pivot).collect(Collectors.toList());
           List<Integer> right = list.stream().filter(x->x<pivot).collect(Collectors.toList());

           //rec sort and concate.
            return Stream.concat(
                    Stream.concat(quickSort(left).stream(), middle.stream()),
                    quickSort(right).stream()
            ).collect(Collectors.toList());
        }
    }
}
class MergeSortStream{
    public List<Integer> mergeSort(List<List<Integer>> list){
        List<Integer> result = list.stream().flatMap(List::stream).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        return result;
    }
}
class QuickSortWithoutStream{
    private int partition(List<Integer> list, int low, int high){
        int pivot = list.get(high);
        int i = low-1;
        for(int j= low;j<high;j++){
            if(list.get(j)<=pivot){
                i++;
                swap(list,i,j);
            }
        }
        swap(list,i+1,high);
        return i+1;
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public void quickSort(List<Integer>list, int low, int high){
        if(low<high){
            int pivot = partition(list, low, high);
            quickSort(list, low, pivot - 1);
            quickSort(list, pivot + 1, high);
        }
    }
}
//class MergeSortWithoutStream{
//    private int partition(List<Integer> list, int low, int high){
//
//    }
//}
public class SortingApp {
}
