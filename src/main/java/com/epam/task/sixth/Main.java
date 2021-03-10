package com.epam.task.sixth;

import com.epam.task.sixth.data.DataReader;
import com.epam.task.sixth.entities.*;
import com.epam.task.sixth.exception.DataReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Main {

    private final static String DATA_FILE = "src/main/resources/ships.json";
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws DataReaderException {
        DataReader reader = new DataReader();
        Ships shipsWrapper;
        try {
            shipsWrapper = reader.readData(DATA_FILE);
        } catch (DataReaderException e) {
            LOGGER.error("An error occurred while reading file - " + e.getMessage());
            throw e;
        }
        ExecutorService service = Executors.newFixedThreadPool(shipsWrapper.getSize());
        List<Ship> ships = shipsWrapper.getShips();
        Stream<Ship> stream = ships.stream();
        stream.forEach(service::submit);
        service.shutdown();
    }

}
