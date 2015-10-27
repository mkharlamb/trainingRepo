package edu.exceptions;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationExceptionClass {

    private static void exceptionWhileRemovingKey(){
        Map<String, Integer> map = new ConcurrentHashMap<>();

//        Map<String, Integer> map = new HashMap<>();
//        Using here usual HashMap leads to ConcurrentModificationException while iterating keySet and removing its pair.


        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);


        for(String key: map.keySet()) {
            if(map.get(key) == 1)
                map.remove(key);
        }

        System.out.println("Successfully removed a pair!");
    }

    private static void exceptionWhilePrinting() {
        List<String> list = new ArrayList<String>();

        list.add("Value1");
        list.add("Value2");
        list.add("Value3");

        Iterator<String> ite = list.iterator();

//        list.remove(1);
        //will get here ConcurrentModificationException because of removing element from list by using it`s own remove
        // not iterator`s one

//        while (ite.hasNext()) {
//            System.out.println(ite.next());
//        }

//        Iterator<String> iter = list.iterator();
//        while (iter.hasNext()) {
//            String s = iter.next();
//
//            if (s.equals("Value2")) {
//                iter.remove();
//            }
//            System.out.println(ite.next());
//        }
        //One more place with ConcurrentModificationException
        List<String> strings = new ArrayList<String>(list);
        for (String currentValue : strings)
        {
            if("Value2".equals(currentValue))
                list.remove(currentValue);
            System.out.println(currentValue);
        }
        System.out.println("List agter modifications:" + list.toString());
        //If the task was removing element from the list but anyway print it`s value

    }

    private static void exceptionWhileRemovingUsingIterator() {
        List<String> list = new ArrayList<String>();

        list.add("Value1");
        list.add("Value2");
        list.add("Value3");

        ListIterator<String> ite = list.listIterator();

//        Iterator<String> ite = list.iterator();
//        Iterator<String> ite2 = list.iterator();

        ite.next();
        ite.remove();
        ite.next();
        
        if(ite.hasPrevious()) {
            ListIterator<String> ite2 = list.listIterator(ite.previousIndex());
            ite2.next();
            ite2.remove();
        }

//          second iterator tries to remove the first object as well,the object does
//           not exist and thus, a ConcurrentModificationException is thrown
        //To avoid these situation ListIterator class could be used, so we use previousItertor for check

        System.out.print("Removing successfully!");
    }


    public static void main(String[] args) {
        exceptionWhileRemovingKey();
        exceptionWhilePrinting();
        exceptionWhileRemovingUsingIterator();
    }
}
