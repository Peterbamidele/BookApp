package com.booklibaray.exceptions;

public class BookNotFoundException extends Throwable{
    public BookNotFoundException(){

    }

    public BookNotFoundException(String message){
        super(message);
    }
    public BookNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public BookNotFoundException(Throwable cause){
        super(cause);
    }
}
