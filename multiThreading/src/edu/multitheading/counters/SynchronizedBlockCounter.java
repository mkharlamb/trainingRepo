package edu.multitheading.counters;

public class SynchronizedBlockCounter extends AbstractCounter{
    private int count;

    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public int getValue() {
        return count;
    }
}

