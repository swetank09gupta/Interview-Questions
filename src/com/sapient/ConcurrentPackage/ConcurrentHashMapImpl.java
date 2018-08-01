package com.sapient.ConcurrentPackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*Concurrent hashmap can make changes during runtime as compared to Hashmap which cannot do so
* Also it doesnot show ConcurrentModificationException as show by Hashmap
* Looking at the output, its clear that ConcurrentHashMap takes care of any new entry in the map
* whereas HashMap throws ConcurrentModificationException.
* Actually Iterator on Collection objects are fail-fast i.e any modification in the structure or
* the number of entry in the collection object will trigger this exception thrown by iterator.*/
public class ConcurrentHashMapImpl {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> myMap = new ConcurrentHashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("ConcurrentHashMap before iterator: "+myMap);

        Iterator <String> iterator = myMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key.equals("3")) {
                myMap.put(key+"new" , "new3");
            }
        }
        System.out.println("ConcurrentHashMap after iterator: "+myMap);

        Map <String, String> myMap1 = new HashMap<>();
        myMap1.put("1", "1");
        myMap1.put("2", "1");
        myMap1.put("3", "1");
        myMap1.put("4", "1");
        myMap1.put("5", "1");
        myMap1.put("6", "1");
        System.out.println("HashMap before iterator: "+myMap1);

        Iterator<String> iterator1 = myMap1.keySet().iterator();
        while (iterator1.hasNext()) {
            String key = iterator1.next();      // This line throws exception
            if (key.equals("3")) {
                myMap1.put(key+"new", "3new");
            }
        }
    }
}
