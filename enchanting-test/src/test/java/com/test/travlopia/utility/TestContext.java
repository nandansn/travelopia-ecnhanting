package com.test.travlopia.utility;


import com.test.travelopia.error.PropertyFileException;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestContext {

    String testPropertiesPath;
    TestProperties testProperties;

    public TestContext(String path) {
        this.testPropertiesPath = path;
    }

    public void setProperties() {
        try {
            this.testProperties = new PropertiesParser<TestProperties>(this.testPropertiesPath, TestProperties.class).getProperty();
        } catch (IOException e) {
            e.printStackTrace();
            throw new PropertyFileException(e.getMessage());
        }
    }

    public TestProperties getProperties () {
        return this.testProperties;
    }
}
