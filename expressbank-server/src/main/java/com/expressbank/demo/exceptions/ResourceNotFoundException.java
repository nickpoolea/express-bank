package com.expressbank.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
	
	    private static final long serialVersionUID = 1L;

	    public ResourceNotFoundException(String resource, String name, Object value){
	    	super(String.format("%s not found with %s %s!", resource, name, value));
	    }
}
