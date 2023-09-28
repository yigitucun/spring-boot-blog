package com.yigit.blog.exceptions.businessException;

import com.yigit.blog.exceptions.ExceptionDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessExceptionHandler  {
    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> handleBusinessException(BusinessException businessException){
        ExceptionDetails exceptionDetails = new ExceptionDetails();
        exceptionDetails.setMessage(businessException.getMessage());
        exceptionDetails.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(exceptionDetails, businessException.getHttpStatus());
    }
}
