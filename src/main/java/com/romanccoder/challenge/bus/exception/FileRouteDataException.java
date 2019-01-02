package com.romanccoder.challenge.bus.exception;

// Separate exception for problems, which occured while loading/reading file
public class FileRouteDataException extends BusChallengeException {

    private String filePath;

    public FileRouteDataException(String filePath, String message) {
        this(filePath, message, null);
    }

    public FileRouteDataException(String filePath, String message, Throwable cause) {
        super(message, cause);
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
