package ru.netology.authservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.authservice.exception.InvalidCredentials;
import ru.netology.authservice.exception.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> responseEntityInvCredentials(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> responseEntityUnauthorizedUser(UnauthorizedUser e) {
        System.out.println(e.getMessage() + " (" + HttpStatus.NOT_FOUND + ")");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
