package com.ctfera.notificacao_app.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proposta {


    private Long id;

    private Double valorSolicitado;
    private int prazoPagamento; //tipo primitivo
    private Boolean aprovada;
    private boolean integrada;  //tipo primitivo
    private String observacao;


    private Usuario usuario;


}
