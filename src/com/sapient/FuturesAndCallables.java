package com.sapient;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FuturesAndCallables implements Callable{

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<Future<String>>();
        FuturesAndCallables callables = new FuturesAndCallables();

        for (int i = 0; i<100; i++) {
            Future<String > future = service.submit(callables);
            list.add(future);
        }
        for (Future<String > fut : list) {
            try {
                System.out.println("Swetank " + fut.get() + " Akanksha ");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(2000);
       // System.out.println("Dravit ");
        return "Dravit " + Thread.currentThread().getName() + " Priyanshi";
    }
}
