package com.epam.task.sixth.entities;

public class Dock {

    public void serviceShip(Ship ship) {
        boolean isLoaded = ship.isLoaded();
        if(isLoaded) {
            ship.setState(false);
        } else {
            ship.setState(true);
        }
    }

}
