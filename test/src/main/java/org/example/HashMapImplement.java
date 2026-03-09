package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapImplement {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Amit", 1);
        map.put("Berlin", 2);
        map.put("Daniel", 3);
        map.put("Harrison", 4);
        map.put("Jeremy", 5);
        map.put("Karl", 3);
        LinkedHashMap<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        //map.entrySet().stream().filter((y) -> y.getValue() % 2 != 0).forEach(System.out::println);
        sortedMap.entrySet().stream().forEach(System.out::println);

    }
}
