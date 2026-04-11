package org.example;

import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@NoArgsConstructor
public class StreamAppProblems {

    protected static List<Employee> populateEmployee() {
        List<Employee> employees = List.of(
                new Employee(1, "Amit", "Director", 4500000.0),
                new Employee(2, "Rahul", "Director", 5500000.0),
                new Employee(3, "Ashu", "Director", 5500000.0),
                new Employee(3, "Rohit", "Manager", 250000.0),
                new Employee(4, "Vaibhav", "Lead", 150000.0));
        return employees;
    }

    protected static List<Employee> populateEmployeesWithDept() {
        List<Employee> employees = List.of(
                new Employee(1, "Amit", "Director", "IT", 4500000.0),
                new Employee(2, "Rahul", "Director", "IT", 5500000.0),
                new Employee(3, "Ashu", "Director", "HR", 250000.0),
                new Employee(4, "Vaibhav", "Lead", "JAVA", 150000.0));
        return employees;
    }

    public static Map<Integer, Employee> populateEmployeeMap() {
        Map<Integer, Employee> employees = new HashMap<>();
        employees.put(1, new Employee(1, "Amit", "Director", 4500000.0));
        employees.put(2, new Employee(2, "Rahul", "Director", 5500000.0));
        employees.put(3, new Employee(3, "Rohit", "Manager", 250000.0));
        employees.put(4, new Employee(4, "Vaibhav", "Lead", 150000.0));
        return employees;
    }

    public void filterEmployees() {
        List<Employee> employees = populateEmployee();
        List<Employee> filter = employees.stream().filter(empl -> empl.getDesignation().equals("Director")).sorted(Comparator.comparing(Employee::getSalary)).filter(emp -> emp.getSalary() > 4600000).collect(Collectors.toList());
        filter.forEach(System.out::println);
    }

    public Employee minSalaryEmployee() {
        return populateEmployee().stream().min(Comparator.comparing(Employee::getSalary)).orElse(new Employee());
    }

    public List<Employee> removeDuplicateIfAny() {
        return populateEmployee().stream().distinct().collect(Collectors.toList());
    }

    public List<Integer> oddEven() {
        List<Integer> odd = List.of(1, 2, 3, 4, 5);
        return odd.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
    }

    public static String wordWithMostvowel() {
        List<String> listOfWords = List.of("Stream", "java", "Programming", "Awsome");
        return listOfWords.stream().max(Comparator.comparing(word -> (int) word.chars().filter(c -> "aeiou".indexOf(c) != -1).count())).orElse("");
    }

    public static List<Integer> fibonacci() {
        int n = 14;
        return Stream.iterate
                        (new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(n).map(arr -> arr[0]).collect(Collectors.toList());
    }

    public static List<Employee> highesPaidEmployees() {
        List<Employee> employees = populateEmployeesWithDept();
        employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingDouble(e -> e.getSalary())),
                Optional::get
        )));
        return employees;
    }

    public static Map<Character, Integer> convertCounting() {
        List<String> stringList = List.of("Stream", "Java", "Programming", "Awsome");
        Map<Character, Integer> characterToCount = stringList.stream()
                // 1. Flatten all strings into a stream of characters
                .flatMap(s -> s.chars().mapToObj(c -> (char) c))
                // 2. Group by the character and sum the occurrences
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.summingInt(c -> 1)
                ));
        return characterToCount;
    }

    public static List<String> subsequence() {
        //List<String> stringList = List.of("Stream","Java");
        String str = "abc";
        List<String> subsequences = IntStream.range(0, 1 << str.length())
                .mapToObj(i -> IntStream.range(0, str.length())
                        .filter(j -> (i & (1 << j)) != 0)
                        .mapToObj(j -> String.valueOf(str.charAt(j)))
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());
        return subsequences;
    }

    public static List<Character> filterCharacter() {
        List<Character> characters = List.of(
                'a', 'b', 'c');
        return characters.stream().filter(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u').collect(Collectors.toList());
    }

    public static List<String> reduceExample() {
        List<String> data = List.of("Stream", "Java", "Programming", "Awsome");
        List<String> data2 = List.of("Amit", "Kulkarni");
        return data2;
    }

    public static List<Integer> getCommonElements(List<Integer> list1,List<Integer> list2){
     return list1.stream()
             .filter(list2::contains)
             .collect(Collectors.toList());
        // return list1.stream().filter(e->!list2.contains(e)).collect(Collectors.toList());
    }
    public static List<Integer> removeElements() {
        Integer[] array = {21, 10, 20, 10, 30, 50, 20, 60, 19, 20, 19, 20, 20, 70, 80, 20, 90};

        // Step 1: Find the element that occurred the most number of times
        Map.Entry<Integer, Long> mostCommonEntry = Arrays.stream(array)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        int mostCommonElement = mostCommonEntry.getKey();

        // Step 2: Remove the immediate left and right elements of the most common element
        List<Integer> result = Arrays.stream(array)
                .filter(e -> !(e == mostCommonElement || e == mostCommonElement - 1 || e == mostCommonElement + 1))
                .collect(Collectors.toList());

        System.out.println("Most common element: " + mostCommonElement);
        System.out.println("Resulting array after removing immediate left and right elements: " + result);
        return result;
    }

    public static void main(String[] args) {
        StreamAppProblems streamAppProblems = new StreamAppProblems();
        streamAppProblems.filterEmployees();
        Comparator<Employee> empComparingByName = (Employee obj1, Employee obj2) -> obj1.getName().compareTo(obj2.getName());
        Map<Integer, Employee> reversMap = populateEmployeeMap().
                entrySet().stream().
                sorted(Map.Entry.comparingByValue(empComparingByName))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)
                        -> e1, LinkedHashMap::new));
        System.out.println(populateEmployeeMap());
        System.out.println("Reverse Map " + reversMap);
        System.out.println(streamAppProblems.minSalaryEmployee());
        System.out.println(streamAppProblems.removeDuplicateIfAny());
        System.out.println(wordWithMostvowel());
        System.out.println(fibonacci());
        System.out.println(highesPaidEmployees());
        System.out.println(subsequence());
        System.out.println(convertCounting());
        System.out.println(filterCharacter());
        System.out.println(reduceExample());
        List<Employee> data = populateEmployee();
        System.out.println(data.stream().map(e -> e.getSalary()).reduce(Double.valueOf(0), (a, b) -> a + b));
        List<Integer> test = List.of(1,1,6, 2, 3, 7, 4,2, 5);
        System.out.println(test.stream().distinct().sorted().collect(Collectors.toList()));
        System.out.println("Removed vowels:"+removedVowels("Hello Word Mth"));
        System.out.println("alternating elements using Streams: "+alterList());
        System.out.println(getCommonElements(List.of(1,2,3,5,6),List.of(6,1,3,4)));
        System.out.println(removeElements());
    }

    private static List<Integer> alterList() {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);

            if(list1.size()!=list2.size())
                throw new IllegalArgumentException("List should must be equal in size");

            List<Integer> lst=IntStream.range(0, list1.size())
                    .mapToObj(i->Arrays.asList(list1.get(i), list2.get(i)))
                    .flatMap(List::stream).collect( Collectors.toList());
            return lst;
    }

    private static String removedVowels(String input) {
        String vowelsRegex = "[AEIOUaeiou]";
        return IntStream.range(0, input.length()) // 1. Get an IntStream of indices
                .mapToObj(input::charAt)                      // 2. Map indices to Character objects
                .filter(c -> !String.valueOf(c).matches(vowelsRegex)) // 3. Filter out vowels
                .map(String::valueOf)                         // 4. Map Characters back to Strings
                .collect(Collectors.joining());
    }
}