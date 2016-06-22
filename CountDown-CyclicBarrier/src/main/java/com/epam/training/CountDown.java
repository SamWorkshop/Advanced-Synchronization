package com.epam.training;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CountDown {

    private static final int NUMBER_OF_THREADS = 3;
    private static final int MAX_SLEEP_TIME = 100;
    private static final int START_FROM = 100;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER_OF_THREADS);

    private static class CountDownThread implements Runnable {
        CyclicBarrier barrier;
        private int start = START_FROM;

        /**
         * 
         * @param barrier
         */
        public CountDownThread(CyclicBarrier barrier) {
            super();
            this.barrier = barrier;
        }

        @Override
        public void run() {

            while (start > 0) {
                try {
                    start--;
                    System.out.println(start);
                    sleepRandomTime();
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            new Thread(new CountDownThread(cyclicBarrier)).start();
        }
    }

    private static void sleepRandomTime() {
        try {
            Thread.sleep(new Random().nextInt(MAX_SLEEP_TIME + 1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
