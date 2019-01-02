package com.romanccoder.challenge.bus.exception;

// Base exception for whole microservice
public class BusChallengeException extends RuntimeException {

    public BusChallengeException(String message) {
        super(message);
    }

    public BusChallengeException(String message, Throwable cause) {
        super(message, cause);
    }
}
