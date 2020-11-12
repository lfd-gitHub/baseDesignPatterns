package com.lfd.cs.creational.dp1_factory;

import com.lfd.cs.creational.dp0_sample.*;

public interface AbstractFactory {

    AbstractProductA createProductA();
    AbstractProductB createProductB();
}


class ConcreteFactory1 implements AbstractFactory{

    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

class ConcreteFactory2 implements AbstractFactory{

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}

abstract class AbstractProductA{

}

class ProductA1 extends AbstractProductA{}
class ProductA2 extends AbstractProductA{}

abstract class AbstractProductB{

}

class ProductB1 extends AbstractProductB{}
class ProductB2 extends AbstractProductB{}


/////////////Maze Sample//////////////
class MazeFactory_AF{

    Maze makeMaze(){
        return new Maze();
    }

    Wall makeWall(){
        return new Wall();
    }

    Door makeDoor(Room r1,Room r2){
        return new Door(r1,r2);
    }

    Room makeRoom(int n){
        return new Room(n);
    }
}

class BombedFactory_AF extends MazeFactory_AF{
    @Override
    Room makeRoom(int n) {
        return new RoomWithABomb(n);
    }

    @Override
    Wall makeWall() {
        return new BombedWall();
    }
}



class MazeGame_AF{
     Maze createMaze(MazeFactory_AF factory){
         Maze aMaze = factory.makeMaze();

         Room r1 = factory.makeRoom(1);
         Room r2 = factory.makeRoom(2);

         Door d1 = factory.makeDoor(r1,r2);

         aMaze.addRoom(r1);
         aMaze.addRoom(r2);

         r1.setMapSite(d1,Direction.East);
         r1.setMapSite(factory.makeWall(),Direction.South);
         r1.setMapSite(factory.makeWall(),Direction.West);
         r1.setMapSite(factory.makeWall(),Direction.South);

         r2.setMapSite(factory.makeWall(),Direction.East);
         r2.setMapSite(factory.makeWall(),Direction.South);
         r2.setMapSite(d1,Direction.West);
         r2.setMapSite(factory.makeWall(),Direction.South);

         return aMaze;
     }
}














