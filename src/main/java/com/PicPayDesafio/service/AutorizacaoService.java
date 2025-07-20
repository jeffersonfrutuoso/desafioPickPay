package com.PicPayDesafio.service;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AutorizacaoService {
    private final AutorizacaoClientService autorizacaoClientService;

    public AutorizacaoService(AutorizacaoClientService autorizacaoClientService) {
        this.autorizacaoClientService = autorizacaoClientService;
    }

    public boolean validarTransferencia(){
        if(Objects.equals(autorizacaoClientService.validarAutorizacao().data().authorization(), "true")){
            return true;
        }
        return false;
    }
}
