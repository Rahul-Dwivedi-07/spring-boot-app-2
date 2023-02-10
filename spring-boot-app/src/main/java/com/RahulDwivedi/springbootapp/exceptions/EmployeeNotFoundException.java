//important to define response body for an exception

package com.RahulDwivedi.springbootapp.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    //this class will have a constructor which will take message as the input

    //the below is a public constructor which will take string message
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
