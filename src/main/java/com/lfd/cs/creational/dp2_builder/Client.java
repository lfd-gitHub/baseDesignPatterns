package com.lfd.cs.creational.dp2_builder;

public class Client {

    public static void main(String[] args) {

        System.out.println(new Director().construct(new ConcreteBuilder()).partA);

        CounterMazeBuilder builder = new CounterMazeBuilder();
        new MazeGame().createMaze(builder);
        System.out.println("rooms:"+builder.getRoomsCount());

    }

}
