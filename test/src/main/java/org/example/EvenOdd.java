package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class EvenOddExecutor {
    int number = 1;
    private int limit;
    final Object lock = new Object();

    public EvenOddExecutor(int limit) {
        this.limit = limit;
    }

    public void printOdd() {
        synchronized (lock) {
            while (number <= limit) {
                while (number % 2 == 0) { // Wait if it's not odd's turn
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= limit) {
                    System.out.println("Odd: " + number);
                    number++;
                    lock.notify(); // Notify the even thread
                }
            }
        }
    }

    public void printEven() {
        synchronized (lock) {
            while (number <= limit) {
                while (number % 2 != 0) { // Wait if it's not odd's turn
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= limit) {
                    System.out.println("Even: " + number);
                    number++;
                    lock.notify(); // Notify the even thread
                }
            }
        }
    }
}

public class EvenOdd {
    public static void main(String[] args) {
        EvenOddExecutor printer = new EvenOddExecutor(20);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(printer::printOdd);
        executorService.submit(printer::printEven);
        executorService.shutdown();
    }
}