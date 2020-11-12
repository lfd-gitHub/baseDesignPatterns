package com.lfd.cs.creational.dp0_sample;

public class Room implements MapSite {

    private int roomNo;
    private MapSite[] mapSites = new MapSite[4];

    public Room(int roomNo) {
        this.roomNo = roomNo;
    }

    public MapSite getMapSite(Direction direction) {
        return mapSites[direction.ordinal()];
    }

    public MapSite[] getMapSites() {
        return mapSites;
    }

    public void setMapSite(MapSite mapSite, Direction direction) {
        this.mapSites[direction.ordinal()] = mapSite;
    }

    public int getRoomNo() {
        return roomNo;
    }

    @Override
    public void enter() {

    }
}
