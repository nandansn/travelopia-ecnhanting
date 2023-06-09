package com.test.travlopia.utility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class TestProperties  extends Properties{

    @JsonProperty("app_url")
    String url;

    @JsonProperty("environments")
    List<EnvironmentProperty> environmentsProperty;

    public String getUrl() {
        return url;
    }

    public List<EnvironmentProperty> getEnvironmentProperty() {
        return environmentsProperty;
    }
}
