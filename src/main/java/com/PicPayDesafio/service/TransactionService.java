package com.PicPayDesafio.service;

import com.PicPayDesafio.domain.user.User;
import com.PicPayDesafio.dtos.TransactionDTO;
import com.PicPayDesafio.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class TransactionService {

    private final UserService userService;

    private final TransactionRepository transactionRepository;

    public TransactionService(UserService userService, TransactionRepository transactionRepository) {
        this.userService = userService;
        this.transactionRepository = transactionRepository;
    }

    public void createTransaction(TransactionDTO transactionDTO){
        User enviador = userService.findUserById(transactionDTO.enviadorId());
        User recebedor = userService.findUserById(transactionDTO.recebedorId());

        userService.validarTransaction(enviador, transactionDTO.valor());
    }
}
