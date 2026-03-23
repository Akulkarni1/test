package org.example;

import java.util.stream.IntStream;

public class Palingdrome {
    //leetcode Problem 9.
    public static void main(String[] args) {
        String str = "10";
        boolean flag = IntStream.range(0, str.length() / 2)
                .allMatch((x) -> {
                    return str.charAt(x) == str.charAt(
                            str.length() - 1 - x);
                });
        System.out.println(flag);
    }
}
