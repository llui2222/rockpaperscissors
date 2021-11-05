package com.hometask.rockpaperscissors.exception;

public class GameIsCompleted extends RuntimeException {

    public GameIsCompleted() {
    }

    public GameIsCompleted(String message) {
        super(message);
    }

    public GameIsCompleted(String message, Throwable cause) {
        super(message, cause);
    }

    public GameIsCompleted(Throwable cause) {
        super(cause);
    }

    public GameIsCompleted(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
