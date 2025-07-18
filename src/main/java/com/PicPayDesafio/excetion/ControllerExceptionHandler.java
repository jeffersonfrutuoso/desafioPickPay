package com.PicPayDesafio.excetion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UnauthorizedTransactionException.class)
    public ResponseEntity<Map<String, String>> handlerUnauthorizedTransactionException (UnauthorizedTransactionException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("error", exception.getMessage());
        response.put("message", "usuario do tipo lojista nao esta autorizado a enviar dinheiro");
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<Map<String, String>> handlerInsufficientBalanceException (InsufficientBalanceException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("error", exception.getMessage());
        response.put("message", "Você nao tem saldo suficiente");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlerUserNotFoundExceptionException (UserNotFoundException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("error", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
