package com.yigit.blog.exceptions.methodArgumentException;

import com.yigit.blog.exceptions.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MethodArgumentException {
    @ExceptionHandler
    private ExceptionDetails handleMethodArgumentException(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException){
        ExceptionDetails details = new ExceptionDetails();
        details.setMessage("Geçersiz veri.");
        details.setTimestamp(System.currentTimeMillis());
        return details;
    }
}