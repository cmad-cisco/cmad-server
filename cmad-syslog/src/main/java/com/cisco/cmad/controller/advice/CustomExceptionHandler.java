package com.cisco.cmad.controller.advice;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cisco.cmad.dto.ErrorResponse;

//@ControllerAdvice
@ResponseBody
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ErrorResponse> handleConstraintViolation(
                                            ConstraintViolationException ex,
                                            WebRequest request)
    {
        List<String> details = ex.getConstraintViolations()
                                    .parallelStream()
                                    .map(e -> e.getMessage())
                                    .collect(Collectors.toList());
 
        ErrorResponse error = new ErrorResponse("BAD_REQUEST", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
