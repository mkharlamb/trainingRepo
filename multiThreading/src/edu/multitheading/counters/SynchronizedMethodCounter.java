package edu.multitheading.counters;


public class SynchronizedMethodCounter extends AbstractCounter {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public int getValue() {
        return count;
    }
}
