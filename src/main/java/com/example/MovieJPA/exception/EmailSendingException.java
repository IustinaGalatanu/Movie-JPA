package com.example.MovieJPA.exception;

public class EmailSendingException extends Exception{
    public EmailSendingException(String message){
        super(message);
    }
}
