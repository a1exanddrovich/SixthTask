package com.epam.task.sixth.data;

import com.epam.task.sixth.entities.Ships;
import com.epam.task.sixth.exception.DataReaderException;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;

public class DataReader {

    public Ships readData(String fileData) throws DataReaderException {
        Ships ships;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            ships = mapper.readValue(Paths.get(fileData).toFile(), Ships.class);
        } catch (IOException e) {
            throw new DataReaderException(e);
        }
        return ships;
    }

}
