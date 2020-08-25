package com.example.kafka.Lambda;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        ArrayList<Student> l= new ArrayList<Student>();
        l.add(new Student("A",55));
        l.add(new Student("B",85));
        l.add(new Student("C",77));
        l.add(new Student("D",42));
        l.add(new Student("E",80));
        Function<Student,String> f= s->{
            int marks=s.marks;
            if(marks>=80) {
                return "A[Dictinction]";
            }else if(marks>=60) {
                return "B[First Class]";
            }else if(marks>=50) {
                return "C[Second Class]";
            }else if(marks>=35) {
                return "D[Third Class]";
            }else {
                return "E[Failed]";
            }
        };
        Predicate<Student> p= s->s.marks>=60;
        for(Student s : l) {
            if(p.test(s)) {
                System.out.println("Student Name:"+s.name);
                System.out.println("Student Marks:"+s.marks);
                System.out.println("Student Grade:"+f.apply(s));
                System.out.println();
            }
        }
    }
}
