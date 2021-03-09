package com.epam.task.sixth.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ship implements Runnable {

    private int id;
    private boolean loaded;
    private final static Logger LOGGER = LogManager.getLogger(Ship.class);

    public Ship() { }

    public int getId() {
        return this.id;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public void setState(boolean loaded) {
        this.loaded = loaded;
    }

    @Override
    public void run() {
        LOGGER.info("Ship " + this.getId() + " entering the port...");
        Port port = Port.getInstance();
        port.getService(this);
        LOGGER.info("Ship " + this.getId() + " has left the port");
    }

}
