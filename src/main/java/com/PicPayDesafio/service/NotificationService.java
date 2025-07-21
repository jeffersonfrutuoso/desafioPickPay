package com.PicPayDesafio.service;

import com.PicPayDesafio.domain.user.User;
import com.PicPayDesafio.dtos.mockAutorizacao.NotificacaoDTO;
import com.PicPayDesafio.excetion.ServiceNotificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    private final RestTemplate restTemplate;

    @Value("${notificacao.url}")
    private String notificacaoUrl;

    public NotificationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void enviarNotificacao(User usuario, String mensagem){
        String email = usuario.getEmail();
        NotificacaoDTO notificacaoDTO = new NotificacaoDTO(email, mensagem);

        System.out.println("notificação enviada com sucesso");
    }
}
