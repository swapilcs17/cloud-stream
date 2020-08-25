package com.example.kafka.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectEx {

    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        l.add("India");
        l.add("Spain");
        l.add("Germany");
        l.add("Argentina");
        l.add("Portugal");
        l.add("France");

        List<String> l1 = l.stream().filter(s->s.length()>=7).collect(Collectors.toList());
        System.out.println(l1);


        List<String> l2 = l.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(l2);
    }
}
