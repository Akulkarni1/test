package org.example;

import java.util.*;

public class PriorityQueueApp {
    //meeting rooms Leetcode 253
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }

    //Sliding window 239
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums == null || k > nums.length) {
            return new int[0];
        }
        PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIdx = 0;
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new Integer[]{nums[i], i});
            while (maxHeap.isEmpty() && maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }
            if (i > k - 1) {
                result[resultIdx++] = maxHeap.peek()[0];
            }
        }
        return result;
    }


public static void main(String[] args) {
    List<Integer> list = List.of(2, 3, 5, 6, 1, 4);
    PriorityQueue<Integer> pq = new PriorityQueue<>(list);
    System.out.println(pq);

    Employee employee = new Employee();

    employee.setId(1);
    employee.setName("Amit K");

    Employee employee2 = new Employee();
    employee2.setId(2);
    employee2.setName("Rohit K");

    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(employee);
    employeeList.add(employee2);

    Comparator<Employee> comparator = Comparator.comparing(Employee::getId);
    PriorityQueue<Employee> priorityQueue = new PriorityQueue<>(comparator);
    priorityQueue.addAll(employeeList);
    priorityQueue.stream().forEach(System.out::println);

}
}
