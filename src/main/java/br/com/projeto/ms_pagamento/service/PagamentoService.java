package br.com.projeto.ms_pagamento.service;

import br.com.projeto.ms_pagamento.model.Pagamento;
import br.com.projeto.ms_pagamento.repository.PagamentoRepository;
import dto.PagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Transactional(readOnly = true)
    public List<PagamentoDTO> findAll() {
        List<Pagamento> list = repository.findAll();
        return list.stream().map(PagamentoDTO::new).collect(Collectors.toList());
    }
}
