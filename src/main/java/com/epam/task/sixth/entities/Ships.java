package com.epam.task.sixth.entities;

import java.util.ArrayList;
import java.util.List;

public class Ships {

    private List<Ship> ships = new ArrayList<>();

    public Ships() {}

    public Ship getShip(int index) {
        return this.ships.get(index);
    }

}
