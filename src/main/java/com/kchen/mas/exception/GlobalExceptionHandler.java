package com.kchen.mas.exception;

import com.kchen.mas.entry.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public JsonResult handleGlobalException(Exception ex, WebRequest request) {
        return JsonResult.FAILURE(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

    // 处理自定义异常
    @ExceptionHandler(CustomException.class)
    public JsonResult handleCustomException(CustomException ex, WebRequest request) {
        return JsonResult.FAILURE(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    // 处理资源未找到异常
    @ExceptionHandler(ResourceNotFoundException.class)
    public JsonResult handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return JsonResult.FAILURE(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
