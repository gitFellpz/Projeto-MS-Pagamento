package br.com.projeto.ms_pagamento.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valor;
    private String nome;
    private String numeroCartao;
    private String validade; //validade MM-AA
    private String codigoSeguranca; //codigo de segurança XXX

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Long pedidoId;

    @Column(nullable = false)
    private Long formaPagamentoId;

}
