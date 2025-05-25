package br.com.projeto.ms_pagamento.repository;

import br.com.projeto.ms_pagamento.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
