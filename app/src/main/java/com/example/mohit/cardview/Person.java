package com.example.mohit.cardview;

/**
 * Created by mohit on 20/5/16.
 */
public class Person {
    private String name;
    private int id;

    Person(String name,int id) {
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public String getId() {
        return Integer.toString(this.id);
    }
}
