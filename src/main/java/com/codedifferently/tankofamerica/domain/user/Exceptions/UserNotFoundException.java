package com.codedifferently.tankofamerica.domain.user.Exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message){
        super(message);
    }
}
