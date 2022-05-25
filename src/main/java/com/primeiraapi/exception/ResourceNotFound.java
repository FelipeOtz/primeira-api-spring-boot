package com.primeiraapi.exception;

import java.time.Instant;

public record ResourceNotFound(Instant timestamp, Integer status, String error, String message, String path){

}
