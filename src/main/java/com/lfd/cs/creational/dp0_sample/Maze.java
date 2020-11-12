package com.lfd.cs.creational.dp0_sample;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room){
        rooms.add(room);
    }

    public Room getRoom(int roomNo){
        for (Room room : rooms) {
            if(room.getRoomNo() == roomNo)return room;
        }
        return null;
    }

}



