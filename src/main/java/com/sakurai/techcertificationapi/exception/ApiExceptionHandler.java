package com.sakurai.techcertificationapi.exception;

import java.net.URI;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.validation.FieldError;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    /* TODO: create exception handlers */

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDtoWrapper> handleException(Exception e) {
        return ResponseEntity.status(500).body(new ErrorDtoWrapper("internalError", "Something went wrong."));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail problem = ProblemDetail.forStatus(status);
        problem.setTitle("One or more fields are invalid.");
        problem.setType(URI.create("errors/invalid-body-fields"));

        var fields = ex.getBindingResult().getAllErrors().stream()
                .collect(Collectors.toMap(
                    error -> ((FieldError) error).getField(),
                    error -> error.getDefaultMessage()
                ));
        problem.setProperty("fields", fields);

        return super.handleExceptionInternal(ex, problem, headers, status, request);
    }
    
}
