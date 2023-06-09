package com.test.travelopia.error;

public enum TestErrorCodes {

    E500("File Errors", "E500");

    TestErrorCodes(String message, String eCode) {
        this.eCode = eCode;
        this.message = message;
    }

    String message;
    String eCode;

    public String getDetails() {
        return String.format("%s -  %s:",this.eCode, this.message);
    }
}
