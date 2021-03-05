package com.epam.task.sixth.entities;

import java.util.concurrent.locks.ReentrantLock;

public class Dock {

    public void serviceShip(Ship ship) {
        ReentrantLock locking = new ReentrantLock();
        locking.lock();
        boolean isLoaded = ship.getState();
        if(isLoaded) {
            ship.setState(false);
        } else {
            ship.setState(true);
        }
        locking.unlock();
    }

}
