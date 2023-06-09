package com.test.travlopia.utility;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrowserProperty {
    @JsonProperty("name")
    private String name;

    @JsonProperty("maximize-window")
    private boolean isMaximize;

    public String getName() {
        return name;
    }

    public boolean isMaximize() {
        return isMaximize;
    }


    public void setName(String name) {
        this.name = name;
    }
}
