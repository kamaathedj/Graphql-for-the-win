package com.kamaathedj.Graphql;

public interface WhatInterface {

    public String Eat();

    public void consume();

    public static String what() {
        return "static method";
    }


    default String defaultMethod() {
        return Eat();
    }

    default String mdata() {
        return "5";
    }
}
