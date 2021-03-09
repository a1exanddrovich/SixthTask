package com.epam.task.sixth.entities;

public class LoadedState extends State {

    public LoadedState(Ship ship) {
        super(ship);
        ship.setLoaded(true);
    }

    @Override
    public void unload() {
        ship.setLoaded(false);
    }

    @Override
    public void load() {
        System.out.println("The ship is downloaded...");
    }

}
