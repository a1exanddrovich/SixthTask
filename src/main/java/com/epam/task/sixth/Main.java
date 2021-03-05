package com.epam.task.sixth;

import com.epam.task.sixth.entities.Ships;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    private final static String PATH = "{\n" +
            "  \"ships\" : [\n" +
            "    {\n" +
            "      \"id\" : \"1\",\n" +
            "      \"loaded\" : \"true\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\" : \"2\",\n" +
            "      \"loaded\" : \"false\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\" : \"3\",\n" +
            "      \"loaded\" : \"true\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\" : \"4\",\n" +
            "      \"loaded\" : \"false\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\" : \"5\",\n" +
            "      \"loaded\" : \"true\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\" : \"6\",\n" +
            "      \"loaded\" : \"false\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\" : \"7\",\n" +
            "      \"loaded\" : \"true\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\" : \"8\",\n" +
            "      \"loaded\" : \"false\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\" : \"9\",\n" +
            "      \"loaded\" : \"true\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\" : \"10\",\n" +
            "      \"loaded\" : \"false\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\" : \"11\",\n" +
            "      \"loaded\" : \"true\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\" : \"12\",\n" +
            "      \"loaded\" : \"false\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    private final static int THREADS_NUMBER = 12;
    private final static int DOCKS_NUMBER = 3;

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        Ships ships = null;
        try {
            ships = mapper.readValue(PATH, Ships.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ExecutorService service = Executors.newFixedThreadPool(DOCKS_NUMBER);
        ArrayList<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < THREADS_NUMBER; i++) {
            Runnable ship = ships.getShip(i);
            Future<?> future = service.submit(ship);
            futures.add(future);

        }
        service.shutdown();
    }

}
