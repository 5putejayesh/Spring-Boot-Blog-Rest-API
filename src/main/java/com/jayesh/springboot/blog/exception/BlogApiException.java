package com.jayesh.springboot.blog.exception;

import org.springframework.http.HttpStatus;

public class BlogApiException extends RuntimeException{
    private HttpStatus httpStatus;
    private  String message;

    public BlogApiException(HttpStatus httpStatus,String message){
        this.httpStatus=httpStatus;
        this.message=message;
    }
    public BlogApiException(HttpStatus httpStatus,String message,String message1){
        super(message1);
        this.httpStatus=httpStatus;
        this.message=message1;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
