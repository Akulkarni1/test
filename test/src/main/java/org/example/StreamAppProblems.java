package org.example;

import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
public class StreamAppProblems {

    List<Employee> populateEmployee(){
       List<Employee> employees = List.of(
                new Employee(1,"Amit", "Director",4500000.0),
                new Employee(2,"Ashu", "Director",5500000.0),
               new Employee(2,"Ashu", "Director",5500000.0),
                new Employee(3,"Rohit", "Manager",250000.0),
                new Employee(4,"Vaibhav", "Lead",150000.0));
       return employees;
    }
    public static Map<Integer, Employee> populateEmployeeMap(){
        Map<Integer, Employee> employees = new HashMap<>();
        employees.put(1, new Employee(1,"Amit", "Director",4500000.0));
        employees.put(2, new Employee(2,"Ashu", "Director",5500000.0));
        employees.put(3, new Employee(3,"Rohit", "Manager",250000.0));
        employees.put(4, new Employee(4,"Vaibhav", "Lead",150000.0));
        return employees;
    }

    public void filterEmployees(){
        List<Employee> employees = populateEmployee();
        List<Employee> filter= employees.stream().filter(empl->empl.getDesignation().equals("Director")).sorted(Comparator.comparing(Employee::getSalary)).filter(emp-> emp.getSalary()>4600000).collect(Collectors.toList());
        filter.forEach(System.out::println);
    }

    public Employee minSalaryEmployee(){
       return populateEmployee().stream().min(Comparator.comparing(Employee::getSalary)).orElse(new Employee());
    }

    public List<Employee> removeDuplicateIfAny() {
     return populateEmployee().stream().distinct().collect(Collectors.toList());
    }

    public List<Integer> oddEven(){
        List<Integer> odd = List.of(1, 2, 3, 4, 5);
        return odd.stream().filter(i->i%2!=0).collect(Collectors.toList());
    }
    public static String wordWithMostvowel(){
        List<String> listOfWords = List.of("Stream","java","Programming","Awsome");
        return listOfWords.stream().max(Comparator.comparing(word->(int)word.chars().filter(c->"aeiou".indexOf(c)!=-1).count())).orElse("");
    }

    public static void main(String[] args) {
        StreamAppProblems streamAppProblems = new StreamAppProblems();
        streamAppProblems.filterEmployees();
        Comparator<Employee> empComparingByName = (Employee obj1, Employee obj2) -> obj1.getName().compareTo(obj2.getName());
        Map<Integer, Employee> reversMap =populateEmployeeMap().

        entrySet().stream().sorted(Map.Entry.comparingByValue(empComparingByName))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(streamAppProblems.minSalaryEmployee());
        System.out.println(streamAppProblems.removeDuplicateIfAny());
        System.out.println(wordWithMostvowel());
    }
}
