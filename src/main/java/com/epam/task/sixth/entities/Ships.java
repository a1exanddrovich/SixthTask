package com.epam.task.sixth.entities;

import java.util.ArrayList;
import java.util.List;

public class Ships {

    private List<Ship> ships = new ArrayList<>();

    public Ships() {}

    public int getSize() {
        return this.ships.size();
    }

    public List<Ship> getShips() {
        return this.ships;
    }

}
