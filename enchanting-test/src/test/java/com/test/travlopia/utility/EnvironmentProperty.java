package com.test.travlopia.utility;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EnvironmentProperty {

    @JsonProperty("name")
    String name;

    @JsonProperty("browsers")
    List<String> browsers;

    @JsonProperty("hub")
    String hubUrl;


    public List<String> getBrowsers() {
        return browsers;
    }
}
