package br.com.projeto.ms_pagamento.controller;

import br.com.projeto.ms_pagamento.service.PagamentoService;
import dto.PagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> findAll() {
        List<PagamentoDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }
}
