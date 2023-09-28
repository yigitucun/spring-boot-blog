package com.yigit.blog.exceptions;

import lombok.Data;

@Data
public class ExceptionDetails {
    private String message;
    private long timestamp;
}
