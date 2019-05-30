package pl.bykowski.springbooterrorhandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IncorrectNameException.class)
    public ResponseEntity<Object> handleWebExeption(IncorrectNameException e, WebRequest webRequest) {
        System.err.println(Arrays.toString(e.getStackTrace()));
        return handleExceptionInternal(e, e.getMessage(), HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, webRequest);
    }
}