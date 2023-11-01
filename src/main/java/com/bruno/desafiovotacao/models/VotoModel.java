package com.bruno.desafiovotacao.models;
import jakarta.persistence.*;

@Entity
public class VotoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PautaModel pauta;

    @ManyToOne
    private AssociadoModel associado;

    private boolean voto; // 'true' para 'Sim', 'false' para 'Não'
    // outros atributos e métodos getters/setters

    // Construtores, getters e setters
    public VotoModel() {
    }

    public VotoModel(PautaModel pauta, AssociadoModel associado, boolean voto) {
        this.pauta = pauta;
        this.associado = associado;
        this.voto = voto;
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

    public AssociadoModel getAssociado() {
        return associado;
    }

    public void setAssociado(AssociadoModel associado) {
        this.associado = associado;
    }

    public boolean isVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }
}