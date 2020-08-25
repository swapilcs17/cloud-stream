package com.example.kafka.Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExample {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(5);
        l.add(1);
        l.add(2);
        l.add(10);
        l.add(7);
        System.out.println("Before Sorting:" +l);
        Collections.sort(l,(a,b) -> (a>b)?-1:(a<b)?1:0);
        System.out.println("After Sorting: "+l);
    }
}
