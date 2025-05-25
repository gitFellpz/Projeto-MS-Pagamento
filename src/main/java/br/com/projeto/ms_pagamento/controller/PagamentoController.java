package br.com.projeto.ms_pagamento.controller;

import br.com.projeto.ms_pagamento.service.PagamentoService;
import br.com.projeto.ms_pagamento.util.ResponseHandler;
import dto.PagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoController {

    String mensagem = null;

    @Autowired
    private PagamentoService service;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<PagamentoDTO> dto = service.findAll();
        mensagem = dto.isEmpty() ? "Nenhum pagamento encontrado." : "Pagamentos retornados com sucesso.";
        return ResponseHandler.gerarResposta(mensagem, HttpStatus.OK, dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        PagamentoDTO dto = service.findById(id);
        mensagem = (dto == null || dto.getId() == null) ? "Pagamento não encontrado" : "Pagamento retornado com sucesso";
        return ResponseHandler.gerarResposta(mensagem, HttpStatus.OK, dto);
    }
}
