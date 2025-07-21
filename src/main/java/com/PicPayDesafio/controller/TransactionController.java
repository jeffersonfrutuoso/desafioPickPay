package com.PicPayDesafio.controller;

import com.PicPayDesafio.domain.transaction.Transaction;
import com.PicPayDesafio.dtos.TransactionDTO;
import com.PicPayDesafio.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

        @PostMapping
        public ResponseEntity<Transaction> createTransaction( @RequestBody TransactionDTO transactionDTO){
            Transaction newTransaction = transactionService.createTransaction(transactionDTO);
            return new ResponseEntity<>(newTransaction, HttpStatus.OK);
        }
}
