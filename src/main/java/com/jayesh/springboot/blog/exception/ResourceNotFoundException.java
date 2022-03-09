package com.jayesh.springboot.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String resourceFieldName;
    private Long resourceFieldValue;

    public ResourceNotFoundException(String resourceName,String resourceFieldName,Long resourceFieldValue){
        super(String.format("%s not found with %s : '%s' ",resourceName,resourceFieldName,resourceFieldValue));
        this.resourceName=resourceName;
        this.resourceFieldName=resourceFieldName;
        this.resourceFieldValue=resourceFieldValue;
    }

    public Long getResourceFieldValue() {
        return resourceFieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceFieldName() {
        return resourceFieldName;
    }
}
