package com.epam.task.sixth.entities;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Port {

    private static Port instance;
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);
    private final static int DOCKS_NUMBER = 3;
    private final Semaphore semaphore = new Semaphore(DOCKS_NUMBER, true);
    private final static Logger LOGGER = LogManager.getLogger(Port.class);

    private Port() {}

    public static Port getInstance(){
        if(!instanceCreated.get()) {
            ReentrantLock lock = new ReentrantLock();
            lock.lock();
            if(!instanceCreated.get()) {
                instance = new Port();
                instanceCreated.set(true);
            }
        }
        return instance;
    }

    public void getService(Ship ship) {
        LOGGER.info("Ship " + ship.getId() + " waiting for a permit...");
        try {
            semaphore.acquire();
            LOGGER.info("Ship " + ship.getId() + " has got a permit");
            Dock dock = new Dock();
            dock.serviceShip(ship);
            LOGGER.info("Ship " + ship.getId() + " has been serviced successfully");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("Ship " + ship.getId() + " has released the permit");
        semaphore.release();
    }

}
