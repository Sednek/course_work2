package com.example.demo.services.examinerService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class onIllegalArgumentException extends IllegalArgumentException {
    public onIllegalArgumentException(String message) {
        super(message);
    }
}