package com.epam.task.sixth.entities;

import java.util.Random;

public class Ship implements Runnable {

    private int id;
    private boolean loaded;

    public Ship() {
    }

    public int getId() {
        return this.id;
    }

    public boolean getState() {
        return this.loaded;
    }

    public void setState(boolean loaded) {
        this.loaded = loaded;
    }

    @Override
    public void run() {
        System.out.println("Ship " + this.getId() + " has entered the port\nThe ship is loaded : " + this.getState());
        Port.enterPort().getService(this);
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ship " + this.getId() + " has left the port\nThe ship is loaded : " + this.getState());
    }

}
