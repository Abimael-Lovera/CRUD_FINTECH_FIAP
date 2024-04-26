package br.com.fiap.fintech.exception;

public class NotFoundEntitiesException extends RuntimeException {
    public NotFoundEntitiesException(String message) {
        super(message);
    }
}
