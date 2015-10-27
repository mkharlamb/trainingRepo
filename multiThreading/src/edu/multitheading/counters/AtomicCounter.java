package edu.multitheading.counters;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter extends AbstractCounter {
    private AtomicInteger count = new AtomicInteger();

    public  void  increment() {
            count.incrementAndGet();
    }

    public int getValue() {
        return count.intValue();
    }


}
