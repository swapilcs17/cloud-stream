package com.example.kafka.Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        List<Employee> l = new ArrayList<Employee>();
        l.add(new Employee(7,"Ronaldo"));
        l.add(new Employee(10,"Messi"));
        l.add(new Employee(11,"Bale"));
        l.add(new Employee(8,"Hazard"));
        l.add(new Employee(4,"Ramos"));

        Collections.sort(l,(a,b) -> (a.eNo>b.eNo)?-1:(a.eNo<b.eNo)?1:0);
        System.out.println(l);
    }
}
