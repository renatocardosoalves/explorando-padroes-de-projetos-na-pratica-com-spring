package one.digitalinnovation.padroesdeprojetospring.exceptions;

import one.digitalinnovation.padroesdeprojetospring.services.customer.exceptions.CustomerNotFoundException;
import one.digitalinnovation.padroesdeprojetospring.services.viacep.exceptions.ZipCodeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;

@RestControllerAdvice
public class GlobalHandleException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ZipCodeNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleNoSuchElementFoundException(ZipCodeNotFoundException exception) {
        return buildErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException exception) {
        return buildErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Object> buildErrorResponse(String message, HttpStatus httpStatus) {
        var errorResponse = new LinkedHashMap<>();
        errorResponse.put("status", httpStatus.value());
        errorResponse.put("message", message);
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }
}
