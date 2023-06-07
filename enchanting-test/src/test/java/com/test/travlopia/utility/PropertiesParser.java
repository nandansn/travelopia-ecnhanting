package com.test.travlopia.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class PropertiesParser<T extends Properties> {

    private Class<T> propertyClass;
    private String path;


    public PropertiesParser(String path, Class<T> propertyClass) {
        this.path = path;
        this.propertyClass = propertyClass;
    }
    public T getProperty() throws IOException {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = new File(this.path);
        return mapper.readValue(file, this.propertyClass);
    }
}
