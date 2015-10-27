package edu.multitheading.counters;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter extends AbstractCounter{
    private ReentrantLock lock = new ReentrantLock();
    private int count;

    public  void  increment() {
        lock.lock();
        count++;
        lock.unlock();
    }

    public int getValue() {
        return count;
    }
}



