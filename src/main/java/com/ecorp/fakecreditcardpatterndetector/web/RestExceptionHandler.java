package com.ecorp.fakecreditcardpatterndetector.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid dayNumber argument")
    @ExceptionHandler({ IllegalArgumentException.class, ConversionFailedException.class })
    public void handleException(Exception ex, WebRequest request) {
        log.error("Invalid dayNumber argument", ex.getMessage(), ex.getCause());
    }

}
