package com.test.travlopia.utility;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EnvironmentProperty {

    @JsonProperty("name")
    String name;

    @JsonProperty("browsers")
    List<BrowserProperty> browsers;

    @JsonProperty("hub")
    String hubUrl;


    public String getName() {
        return name;
    }

    public String getHubUrl() {
        return hubUrl;
    }

    public List<BrowserProperty> getBrowsers() {
        return browsers;
    }
}
