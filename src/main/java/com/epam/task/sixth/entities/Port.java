package com.epam.task.sixth.entities;

import java.util.concurrent.Semaphore;

public class Port {

    private static volatile Port instance;
    private final static int DOCKS_NUMBER = 3;
    private final Semaphore semaphore = new Semaphore(DOCKS_NUMBER, true);

    private Port() {}

    public static Port enterPort() {
        Port localInstance = instance;
        if(localInstance == null) {
            synchronized (Port.class) {
                localInstance = instance;
                if(localInstance == null) {
                    instance = localInstance = new Port();
                }
            }
        }
        return localInstance;
    }

    public boolean getAccess() {
        return semaphore.tryAcquire();
    }

    public void getService(Ship ship) {
        try{
            Dock dock = new Dock();
            dock.serviceShip(ship);
        } finally {
            semaphore.release();
        }
    }

}
