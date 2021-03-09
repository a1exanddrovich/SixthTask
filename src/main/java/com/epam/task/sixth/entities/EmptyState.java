package com.epam.task.sixth.entities;

public class EmptyState extends State {

    public EmptyState(Ship ship) {
        super(ship);
        ship.setLoaded(false);
    }

    @Override
    public void unload() {
        System.out.println("The ship is empty...");
    }

    @Override
    public void load() {
        ship.setLoaded(true);
    }

}
