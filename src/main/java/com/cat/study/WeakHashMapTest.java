package com.cat.study;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeakHashMapTest {

    public static void main(String[] args) {
        Map<String, Object> map = new WeakHashMap<>();

        String s = new String("Hello");
        map.put(s, "World");

        s = null;
        System.gc();

        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> {
            System.out.println(map.size());
        }, 1, 3, TimeUnit.SECONDS);
    }
}
