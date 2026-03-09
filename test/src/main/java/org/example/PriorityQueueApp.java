package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueApp {
    public static void main(String[] args) {
        List<Integer> list = List.of(2,3,5,6,1,4);
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
