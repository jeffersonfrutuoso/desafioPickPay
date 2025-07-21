package com.PicPayDesafio.service;

import com.PicPayDesafio.domain.transaction.Transaction;
import com.PicPayDesafio.domain.user.User;
import com.PicPayDesafio.dtos.TransactionDTO;
import com.PicPayDesafio.excetion.UnauthorizedTransactionException;
import com.PicPayDesafio.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final UserService userService;
    private final AutorizacaoService autorizacaoService;
    private final NotificationService notificationService;

    private final TransactionRepository transactionRepository;

    public TransactionService(UserService userService, AutorizacaoService autorizacaoService, NotificationService notificationService, TransactionRepository transactionRepository) {
        this.userService = userService;
        this.autorizacaoService = autorizacaoService;
        this.notificationService = notificationService;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction createTransaction(TransactionDTO transactionDTO){
        User enviador = userService.findUserById(transactionDTO.enviadorId());
        User recebedor = userService.findUserById(transactionDTO.recebedorId());

        userService.validarTransaction(enviador, transactionDTO.valor());

        if (!autorizacaoService.validarTransferencia()){
            throw new UnauthorizedTransactionException("Transação não autorizada pelo mock");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setValorDaTransferencia(transactionDTO.valor());
        newTransaction.setEnviador(enviador);
        newTransaction.setRecebedor(recebedor);
        newTransaction.setTimestamp(LocalDateTime.now());

        enviador.setCarteira(enviador.getCarteira().subtract(transactionDTO.valor()));
        recebedor.setCarteira(recebedor.getCarteira().add(transactionDTO.valor()));

        transactionRepository.save(newTransaction);
        userService.saveUser(enviador);
        userService.saveUser(recebedor);

        notificationService.enviarNotificacao(enviador, "Transferencia realizada com sucesso");
        notificationService.enviarNotificacao(recebedor, "Transferencia recebida com sucesso");

        return newTransaction;
    }

}
