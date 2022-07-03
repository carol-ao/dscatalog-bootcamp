package com.carol.dscatalog.resources.Exceptions;

import com.carol.dscatalog.services.Exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
        StandardError se = new StandardError();
        se.setError("Entity not found.");
        se.setMessage(e.getMessage());
        se.setPath(request.getRequestURI());
        se.setStatus(HttpStatus.NOT_FOUND.value());
        se.setTimeStamp(Instant.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
    }

}
