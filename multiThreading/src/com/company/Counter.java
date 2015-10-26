package com.company;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
//    private AtomicInteger count = new AtomicInteger();
    private ReentrantLock lock = new ReentrantLock();
    private int count;

    public  void  increment() {
//        synchronized (this){
//            count.incrementAndGet();
//        }
        lock.lock();
        count++;
        lock.unlock();
    }

    public int getValue() {
//        return count.intValue();
        return count;
    }
}

class Incrementer extends Thread {
    private Counter counter;

    public Incrementer(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}

