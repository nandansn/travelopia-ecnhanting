package com.test.travlopia.utility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class TestProperties  extends Properties{

    @JsonProperty("browser")
    BrowserProperty browserProperty;

    @JsonProperty("app_url")
    String url;

    public String getUrl() {
        return url;
    }

    public BrowserProperty getBrowserProperty() {
        return browserProperty;
    }
}
