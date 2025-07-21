package com.PicPayDesafio.excetion;

public class userAlreadyRegisteredException extends RuntimeException{
    public userAlreadyRegisteredException(String message) {
        super(message);
    }
}
