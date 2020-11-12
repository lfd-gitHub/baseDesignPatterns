package com.lfd.cs.creational.dp2_builder;

public class Director {

    Product construct(Builder builder){
        builder.buildPartA("haha");
        return builder.getResult();
    }

}
