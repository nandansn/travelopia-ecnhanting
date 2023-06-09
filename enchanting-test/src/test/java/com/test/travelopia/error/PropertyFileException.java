package com.test.travelopia.error;

public class PropertyFileException extends RuntimeException {

    public PropertyFileException(String message) {
        super(new StringBuilder(TestErrorCodes.E500.getDetails()).append(message).toString());
    }

}
