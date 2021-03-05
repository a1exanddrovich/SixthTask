package com.epam.task.sixth.entities;

import java.util.concurrent.Semaphore;

public class EnterTry {

    private Semaphore semaphore;

    public EnterTry(int docksNumber) {
        this.semaphore = new Semaphore(docksNumber);
    }

    boolean tryEnterPort() {
        return semaphore.tryAcquire();
    }

    public void leavePort() {
        semaphore.release();
    }

    public int availableDocks() {
        return semaphore.availablePermits();
    }

}
