package com.yigit.blog.exceptions.validationException;

import com.yigit.blog.exceptions.ExceptionDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationExceptionDetails  {
    private long timestamp;
    private Map<String,String> validationErrors;
}
