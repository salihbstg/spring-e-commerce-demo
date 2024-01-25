package com.example.ecommercedemo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private int status;
    private long timeStamp;
    private String message;
}
