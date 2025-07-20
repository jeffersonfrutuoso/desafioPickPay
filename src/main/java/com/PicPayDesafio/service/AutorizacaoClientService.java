package com.PicPayDesafio.service;

import com.PicPayDesafio.dtos.mockAutorizacao.AutorizacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

import java.util.List;

@Service
public class AutorizacaoClientService {

    @Autowired
    private final RestTemplate restTemplate;

    @Value("${autorizacao.url}")
    String url;

    public AutorizacaoClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AutorizacaoDTO validarAutorizacao(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<AutorizacaoDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                AutorizacaoDTO.class
        );

        return response.getBody();
    }
}
