package com.EmployeeManagementSystem.ExceptionalHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleException1(ResourceNotFoundException e){
        ResponseEntity res = ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());

        return new ResponseEntity<>(buildError("Incorrect Details", res.getBody().toString(),res.getStatusCode()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ErrorMessage> handleException2(BadRequest e){
        ResponseEntity res = ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());

        return new ResponseEntity<>(buildError("Wrong Body", res.getBody().toString(),res.getStatusCode()),HttpStatus.NOT_FOUND);
    }


    private ErrorMessage buildError(String errorTitle, String detail, HttpStatus httpStatus){

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setTitle(errorTitle);
        errorMessage.setDetail(detail);
        errorMessage.setTitle(HttpStatus.NOT_FOUND.toString());

        return errorMessage;
    }
}
