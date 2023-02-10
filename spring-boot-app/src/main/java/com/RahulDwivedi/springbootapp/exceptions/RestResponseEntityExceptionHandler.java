package com.RahulDwivedi.springbootapp.exceptions;

import com.RahulDwivedi.springbootapp.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//this class will run whenever there are cross cutting concerns to handle for particular controllers
//defining advice for our controller that's why below annotation
//this advice will work only when there are exceptions
//this class is created for ExceptionHandler only
@ControllerAdvice
//this class we are using to handle all our exceptions
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    //method to handle exception

    //exception handler for what(which exception)
    @ExceptionHandler(EmployeeNotFoundException.class)
    //this method will return response body in return
    @ResponseBody
    //have a particular status to return -- if we do not define it, it will by default send 200 but we want a different HTTP status message to return
    //NOT_FOUND is 404
    @ResponseStatus(HttpStatus.NOT_FOUND)
    //ErrorMessage to send data back
    //we want to handle EmployeeNotFoundException that's why injecting it
    public ErrorMessage employeeNotFoundHandler(EmployeeNotFoundException exception){
        //create error message object and send it back
        //for this ErrorMessage only a default constructor is available
        //for passing 2 things in ErrorMessage() we created 2 constructors
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());

        //return message object
        return message;
    }

    //2nd method
    //for generic exception
    //instead of EmployeeNotFoundException define general exception, overall this should be called
    @ExceptionHandler(Exception.class)
    @ResponseBody
    //for general exception pass 500,i.e,Internal Server Error
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    //Instead of EmployeeNotFoundException define general exception
    //whenever there is exception overall, this should be called
    public ErrorMessage genericExceptionHandler(Exception exception){
        ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());

        return message;
    }

    //If we want we can add multiple exception handler and send data back accordingly
}
