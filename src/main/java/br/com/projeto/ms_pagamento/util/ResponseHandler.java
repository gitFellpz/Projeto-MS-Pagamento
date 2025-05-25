package br.com.projeto.ms_pagamento.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHandler {
    public static <T> ResponseEntity<Object> gerarResposta(
            String mensagem,
            HttpStatus status,
            T dados
    ) {
        Map<String, Object> resposta = new LinkedHashMap<>();
        resposta.put("status", status.value());
        resposta.put("mensagem", mensagem);
        resposta.put("dados", dados);
        return new ResponseEntity<>(resposta, status);
    }
}
