package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
//        Counter counter = new Counter();
//        Incrementer it1 = new Incrementer(counter);
//        Incrementer it2 = new Incrementer(counter);
//        it1.start();
//        it2.start();
//        it1.join();
//        it2.join();
//        System.out.println(counter.getValue()); // ???
        Map<String, Integer> map = new HashMap<String, Integer>();
        // Insert some sample key-value pairs.
        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);

          /* Remove a value of the map, while iterating over it.
           * The following code throws a java.util.ConcurrentModificationException. */
        for(String key: map.keySet()) {
            if(map.get(key) == 1)
            map.remove(key);
        }
        System.out.println("Successfully removed a pair!");

    }
}