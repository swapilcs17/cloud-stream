package com.example.kafka.streams;

import java.util.ArrayList;
import java.util.List;

public class ForEachEx {

    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        l.add("India");
        l.add("Spain");
        l.add("Germany");
        l.add("Argentina");
        l.add("Portugal");
        l.add("France");

        l.stream().forEach(s-> System.out.println(s));
    }
}
