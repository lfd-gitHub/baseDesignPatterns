package com.lfd.cs.creational.dp2_builder;

import com.lfd.cs.creational.dp0_sample.*;

public interface Builder {


    Builder buildPartA(String a);

    Builder buildPartB(String b);

    Product getResult();
}

class ConcreteBuilder implements Builder{

    private Product _product;

    public ConcreteBuilder() {
        _product = new Product();
    }

    @Override
    public Builder buildPartA(String a) {
        _product.partA = a;
        return this;
    }

    @Override
    public Builder buildPartB(String b) {
        _product.partB = b;
        return this;
    }

    @Override
    public Product getResult() {
        return _product;
    }
}

class Product{
    String partA;
    String partB;
}

/////////////Maze Sample//////////////

class MazeBuilder{

    protected Maze maze;

    public MazeBuilder() {
        this.maze = new Maze();
    }

    void buildMaze(){};
    void buildRoom(int no){};
    void buildDoor(int roomFrom,int roomTo,Direction dir){}
    Maze getMaze(){return maze;};
}

class CounterMazeBuilder extends MazeBuilder{

    private int mDoors;
    private int mRooms;

    @Override
    void buildRoom(int no) {
        Room room = this.maze.getRoom(no);
        if(room == null){
            this.maze.addRoom(room = new Room(no));
            room.setMapSite(new Wall(), Direction.East);
            room.setMapSite(new Wall(), Direction.West);
            room.setMapSite(new Wall(), Direction.South);
            room.setMapSite(new Wall(), Direction.North);
        }
        mRooms++;
    }

    @Override
    void buildDoor(int roomFrom, int roomTo,Direction dir) {
        Room r1 = this.maze.getRoom(roomFrom);
        Room r2 = this.maze.getRoom(roomTo);
        Door door = new Door(r1,r2);
        r1.setMapSite(door,dir);
        r2.setMapSite(door,dir.getOpposite());
        mDoors++;
    }

    public int getDoorsCount() {
        return mDoors;
    }

    public int getRoomsCount() {
        return mRooms;
    }
}

class MazeGame{
    Maze createMaze(MazeBuilder builder){
        builder.buildRoom(1);
        builder.buildRoom(20000);
        builder.buildDoor(1,20000,Direction.East);
        return builder.getMaze();
    }
}
