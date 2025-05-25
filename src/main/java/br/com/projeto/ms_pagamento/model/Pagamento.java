package br.com.projeto.ms_pagamento.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pagamento {
    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numeroCartao;
    private String validade; //validade MM-AA
    private String codigoSeguranca; //codigo de segurança XXX
    private Status status;
    private Long pedidoId;
    private Long formaPagamento;

}
