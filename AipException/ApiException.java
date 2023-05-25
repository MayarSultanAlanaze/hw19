package com.example.demo.AipException;

public class ApiException extends RuntimeException {
    public ApiException(String message){
      super(message);
    }
}
