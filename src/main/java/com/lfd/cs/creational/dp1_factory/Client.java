package com.lfd.cs.creational.dp1_factory;

public class Client {

    public static void main(String[] args) {

        ///abstract factory
        ConcreteFactory1 cf1 = new ConcreteFactory1();
        System.out.println(cf1.createProductA().getClass().getSimpleName());
        System.out.println(cf1.createProductB().getClass().getSimpleName());
        ///abstract factor maze game
        new MazeGame_AF().createMaze(new BombedFactory_AF());

        ///factory method
        System.out.println(new ConcreteCreatorA().create().getClass().getSimpleName());
        System.out.println(new ConcreteCreatorB().create().getClass().getSimpleName());
        ///??? factory method maze game
        new BombedMazeGame().createMaze();
    }

}
