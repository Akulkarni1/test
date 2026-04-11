package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch  countDownLatch = new CountDownLatch(3);
        new Thread(new CountDownLatchService("DataBase",2000,countDownLatch)).start();
        new Thread(new CountDownLatchService("Messaging",2000,countDownLatch)).start();
        new Thread(new CountDownLatchService("Catch",2000,countDownLatch)).start();

        System.out.println("This is sample");
        countDownLatch.await();
        System.out.println("Finished");

    }
}

class CountDownLatchService implements Runnable {

    private final String name;
    private int delay;
    private CountDownLatch latch;
    public CountDownLatchService(String name, int delay, CountDownLatch latch) {
        this.name = name;
        this.delay = delay;
        this.latch = latch;
    }
    @Override
    public void run() {
        try{
            Thread.sleep(delay);
            System.out.println(this.name + " is intalized.");
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        finally {
            latch.countDown();
        }
    }
}

