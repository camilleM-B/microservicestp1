package com.example.demo;


import java.util.concurrent.atomic.AtomicInteger;

public class Movie {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final Integer id;
    private  String name;

    Movie(String name) {
        this.id = count.incrementAndGet();
        this.name = name;
    }

    public Integer getId() {return this.id;}

    public void updateName(String name) { this.name = name;}
    
}