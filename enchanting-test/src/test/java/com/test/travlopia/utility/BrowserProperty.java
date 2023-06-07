package com.test.travlopia.utility;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrowserProperty {
    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }
}
