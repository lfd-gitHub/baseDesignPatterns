package com.lfd.cs.creational.dp0_sample;

public class Door implements MapSite {

    private boolean isOpen;
    private Room room1;
    private Room room2;

    public Door(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }

    Room otherSideFrom(Room room) {
        return room == room1 ? room2 : room1;
    }

    @Override
    public void enter() {

    }
}
