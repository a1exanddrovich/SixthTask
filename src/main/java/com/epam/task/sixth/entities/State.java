package com.epam.task.sixth.entities;

public abstract class State {

    Ship ship;

    public State(Ship ship) {
        this.ship = ship;
    }

    public abstract void load();
    public abstract void unload();

}
