package com.ndex.clonemate.global.error;

import com.ndex.clonemate.global.dto.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandlerController.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult<String> handleException(Exception e) {
        LOGGER.error(e.getMessage(), e);

        return ApiResult.<String>builder()
                .success(false)
                .errorMessage(e.getMessage())
                .build();
    }
}
