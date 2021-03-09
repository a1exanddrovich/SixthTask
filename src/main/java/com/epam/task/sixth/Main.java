package com.epam.task.sixth;

import com.epam.task.sixth.entities.Ship;
import com.epam.task.sixth.entities.Ships;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Main {

    private final static String DATA_FILE = "src/main/resources/ships.json";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        Ships shipsWrapper = null;
        try {
            shipsWrapper = mapper.readValue(Paths.get(DATA_FILE).toFile(), Ships.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExecutorService service = Executors.newFixedThreadPool(shipsWrapper.getSize());
        List<Ship> ships = shipsWrapper.getShips();
        Stream<Ship> stream = ships.stream();
        stream.forEach(ship -> service.submit(ship));
        service.shutdown();
    }

}
