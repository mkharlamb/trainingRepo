package edu.multitheading;

import edu.multitheading.counters.*;

public class Main {

    private static void executeThreadSafeIncrement(AbstractCounter counter) {
        Incrementer it1 = new Incrementer(counter);
        Incrementer it2 = new Incrementer(counter);
        it1.start();
        it2.start();
        try {
            it1.join();
            it2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getValue());
    }

    public static void main(String[] args) throws Exception {
        executeThreadSafeIncrement(new ReentrantLockCounter());
        executeThreadSafeIncrement(new AtomicCounter());
        executeThreadSafeIncrement(new SynchronizedMethodCounter());
        executeThreadSafeIncrement(new SynchronizedBlockCounter());
    }
}