package com.example.kafka.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortedEx {

    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        l.add("India");
        l.add("Spain");
        l.add("Germany");
        l.add("Argentina");
        l.add("Portugal");
        l.add("France");
        List<String> l2 = l.stream().sorted().collect(Collectors.toList());
        System.out.println(l2);

        List<String> l3 = l.stream().sorted((a,b) -> - a.compareTo(b)).collect(Collectors.toList());
        System.out.println(l3);
    }
}
