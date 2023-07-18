package com.example.bookstoreproject.exception;

import com.example.bookstoreproject.response.ResponseUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandler {



    //Handle the Exceptions regarding validation
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseUser> validateExceptionHandler(MethodArgumentNotValidException exception) {
        List<FieldError> errorList = exception.getBindingResult().getFieldErrors();
        List<String> errorList1 = errorList.stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
        ResponseUser responseDTO = new ResponseUser("Invalid Format...", errorList1);
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }


    //Handle the custom Exceptions which are not available in database
    @org.springframework.web.bind.annotation.ExceptionHandler(UserException.class)
    public ResponseEntity<ResponseUser> customException(UserException exception) {
        ResponseUser responseDTO = new ResponseUser(exception.getMessage(), "Exception while Request Processing...");
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }


    //Handle media type Not acceptable exception
    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ResponseUser> mediaTypeNotAcceptableHandler(HttpMediaTypeNotAcceptableException exception) {
        ResponseUser responseDTO = new ResponseUser("Invalid Media", "Check media Type ");
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_ACCEPTABLE);
    }

    //Handle method Not supported exception
    @org.springframework.web.bind.annotation.ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ResponseUser> requestMethodNotSupportedHandler(HttpRequestMethodNotSupportedException exception) {
        ResponseUser responseDTO = new ResponseUser("Invalid API call", "Check API!!! ");
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_ACCEPTABLE);
    }

    //Handle the message Not Readable Exception
    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseUser> messageNotReadableHandler(HttpMessageNotReadableException exception){
        ResponseUser responseDTO = new ResponseUser("You are entered not required message ","Check message any mistakes are there..!");
        return new ResponseEntity<>(responseDTO,HttpStatus.BAD_GATEWAY);
    }
}
