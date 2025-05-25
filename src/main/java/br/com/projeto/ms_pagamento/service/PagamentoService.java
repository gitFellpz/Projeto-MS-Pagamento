package br.com.projeto.ms_pagamento.service;

import br.com.projeto.ms_pagamento.model.Pagamento;
import br.com.projeto.ms_pagamento.model.Status;
import br.com.projeto.ms_pagamento.repository.PagamentoRepository;
import dto.PagamentoDTO;
import jakarta.persistence.EntityNotFoundException;
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

    @Transactional(readOnly = true)
    public PagamentoDTO findById(long id) {
        Pagamento entity = repository.findById(id).orElse(null);

        //return new PagamentoDTO(entity);
        return (entity != null) ? new PagamentoDTO(entity) : null;
    }

    @Transactional
    public PagamentoDTO insert(PagamentoDTO dto) {
        Pagamento entity = new Pagamento();
        copyDtoToEntity(dto, entity);
        entity.setStatus(Status.CRIADO); //definindo status criado para o novo pagamento inserido
        entity = repository.save(entity);
        return new PagamentoDTO(entity);
    }

    private void copyDtoToEntity(PagamentoDTO dto, Pagamento entity) {
        entity.setValor(dto.getValor());
        entity.setNome(dto.getNome());
        entity.setNumeroCartao(dto.getNumeroCartao());
        entity.setValidade(dto.getValidade());
        entity.setCodigoSeguranca(dto.getCodigoSeguranca());
        entity.setPedidoId(dto.getPedidoId());
        entity.setFormaPagamentoId(dto.getFormaPagamentoId());
    }

    @Transactional
    public void delete (Long id) {
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Recurso não encontrado.");
        }
    }
}
