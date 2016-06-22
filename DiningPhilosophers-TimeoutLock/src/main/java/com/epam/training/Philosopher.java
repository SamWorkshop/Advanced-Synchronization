package com.epam.training;

import java.util.concurrent.TimeUnit;

public class Philosopher extends Thread {

    private Fork rightFork;
    private Fork leftFork;
    private String name;

    public Philosopher(String name, Fork rightFork, Fork leftFork) {
        this.name = name;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    public void run() {
        while (true) {
            try {
                if (rightFork.tryLock(50, TimeUnit.MILLISECONDS)) {
                    System.out.println(name + " got " + rightFork.getName());
                    if (leftFork.tryLock(50, TimeUnit.MILLISECONDS)) {
                        System.out.println(name + " got " + leftFork.getName());
                        eat();
                    } else {
                        rightFork.unlock();
                        Thread.sleep(200);
                    }
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void eat() {
        try {
            System.out.println("------------------------------   " + name + " is eating! --------------------------------");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted", e);
        }
        finally {
            rightFork.unlock();
            leftFork.unlock();
        }
    }

}
