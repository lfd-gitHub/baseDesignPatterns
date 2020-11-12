package com.lfd.cs.creational.dp1_factory;

import com.lfd.cs.creational.dp0_sample.*;

public class FactoryMethod {

}

interface Product{

}

class ConcreteProductA implements Product{

}

class ConcreteProductB implements Product{

}

interface Creator{
    Product create();
}

class ConcreteCreatorA implements Creator{
    @Override
    public Product create() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB implements Creator{
    @Override
    public Product create() {
        return new ConcreteProductB();
    }
}



/////////////Maze Sample//////////////
class MazeGame_FM{
    public Maze createMaze(){
        Maze aMaze = makeMaze();

        Room r1 = makeRoom(1);
        Room r2 = makeRoom(2);

        Door d1 = makeDoor(r1,r2);

        aMaze.addRoom(r1);
        aMaze.addRoom(r2);

        r1.setMapSite(d1, Direction.East);
        r1.setMapSite(makeWall(),Direction.South);
        r1.setMapSite(makeWall(),Direction.West);
        r1.setMapSite(makeWall(),Direction.South);

        r2.setMapSite(makeWall(),Direction.East);
        r2.setMapSite(makeWall(),Direction.South);
        r2.setMapSite(d1,Direction.West);
        r2.setMapSite(makeWall(),Direction.South);
        return aMaze;
    }

    Maze makeMaze(){ return new Maze();}
    Room makeRoom(int n){ return new Room(n);}
    Wall makeWall(){ return new Wall();}
    Door makeDoor(Room r1,Room r2){ return new Door(r1,r2);}

}

class BombedMazeGame extends MazeGame_FM{

    @Override
    Wall makeWall() {
        return new BombedWall();
    }

    @Override
    Room makeRoom(int n) {
        return new RoomWithABomb(n);
    }
}




