package com.bruno.desafiovotacao.models;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class SessaoVotacaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private PautaModel pauta;

    private LocalDateTime inicio;
    private LocalDateTime fim;
    public SessaoVotacaoModel() {
    }

    public SessaoVotacaoModel(PautaModel pauta, LocalDateTime inicio, LocalDateTime fim) {
        this.pauta = pauta;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PautaModel getPauta() {
        return pauta;
    }

    public void setPauta(PautaModel pauta) {
        this.pauta = pauta;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
}