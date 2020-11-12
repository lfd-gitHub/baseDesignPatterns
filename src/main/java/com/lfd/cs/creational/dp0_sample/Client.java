package com.lfd.cs.creational.dp0_sample;

public class Client {

    public static void main(String[] args) {

    }

}


class MazeGame{

    Maze createMaze(){
        Maze aMaze = new Maze();

        Room r1 = new Room(1);
        Room r2 = new Room(2);

        Door d1 = new Door(r1,r2);

        aMaze.addRoom(r1);
        aMaze.addRoom(r2);

        r1.setMapSite(d1,Direction.East);
        r1.setMapSite(new Wall(),Direction.South);
        r1.setMapSite(new Wall(),Direction.West);
        r1.setMapSite(new Wall(),Direction.South);

        r2.setMapSite(new Wall(),Direction.East);
        r2.setMapSite(new Wall(),Direction.South);
        r2.setMapSite(d1,Direction.West);
        r2.setMapSite(new Wall(),Direction.South);

        return aMaze;
    }

}



