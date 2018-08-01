package com.sapient.ConcurrentPackage;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


class Producer implements Runnable {
    private BlockingQueue queue;

    Producer (BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i= 0; i<10; i++) {
                      try {
                queue.put("1");
                Thread.sleep(4000);
                queue.put("2");
                Thread.sleep(8000);
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Consumer implements Runnable {

    private BlockingQueue deque;

    Consumer (BlockingQueue deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        try {
            System.out.println(deque.take());
            System.out.println(deque.take());
            System.out.println(deque.take());
            } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue blockingQueue = new ArrayBlockingQueue<>(1);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
