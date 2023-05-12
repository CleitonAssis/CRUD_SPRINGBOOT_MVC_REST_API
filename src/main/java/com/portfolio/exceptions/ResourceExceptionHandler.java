package com.portfolio.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundHandling(ResourceNotFoundException exception, WebRequest request) {
        StandardError error = new StandardError(new Date(), HttpStatus.NOT_FOUND.value(), "Recurso não encontrado", exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> globalExceptionHandling(Exception exception, WebRequest request) {
        StandardError error = new StandardError(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro interno do servidor", exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}