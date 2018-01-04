package com.cat.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
            }

            {
                addAll(Arrays.asList(2, 3));
            }
        };

        list.forEach(System.err::println);
    }
}
