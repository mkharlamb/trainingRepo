package edu.multitheading;

import edu.multitheading.counters.AbstractCounter;

class Incrementer extends Thread {
    private AbstractCounter counter;

    public Incrementer(AbstractCounter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}