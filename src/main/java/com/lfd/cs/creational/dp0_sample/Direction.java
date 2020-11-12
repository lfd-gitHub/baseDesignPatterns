package com.lfd.cs.creational.dp0_sample;

public enum Direction {
    North,South,East,West;
    public Direction getOpposite() {
        int n = this.ordinal() % 2 == 0 ? 1 : -1;
        return values()[ordinal() + n];
    }
}
