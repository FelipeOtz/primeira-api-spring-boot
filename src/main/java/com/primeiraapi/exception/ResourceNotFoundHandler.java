package com.primeiraapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceNotFoundHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ResourceNotFound> ResourceNotFoundExceptionHandler(ResponseStatusException responseStatusException, HttpServletRequest request){

        ResourceNotFound resourceNotFound = new ResourceNotFound(
                Instant.now(),
                responseStatusException.getRawStatusCode(),
                "Resource not found",
                responseStatusException.getReason(),
                request.getRequestURI()

        );

        return new ResponseEntity<>(resourceNotFound, responseStatusException.getStatus() );

    }
}
