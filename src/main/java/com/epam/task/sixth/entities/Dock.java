package com.epam.task.sixth.entities;

public class Dock {

    public void serviceShip(Ship ship) {
        boolean isLoaded = ship.isLoaded();
        if(isLoaded) {
            ship.changeState(new EmptyState(ship));
        } else {
            ship.changeState(new LoadedState(ship));
        }
    }

}
