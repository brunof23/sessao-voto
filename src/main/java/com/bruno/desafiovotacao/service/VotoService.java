package com.bruno.desafiovotacao.service;

import com.bruno.desafiovotacao.models.PautaModel;
import com.bruno.desafiovotacao.models.VotoModel;
import com.bruno.desafiovotacao.repository.PautaRepository;
import com.bruno.desafiovotacao.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private PautaRepository pautaRepository;


    public VotoModel votar(Long pautaId, boolean voto) {
        PautaModel pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new RuntimeException("Pauta não encontrada"));


        VotoModel novoVoto = new VotoModel();
        novoVoto.setPauta(pauta);
        novoVoto.setVoto(voto);

        return votoRepository.save(novoVoto);
    }
}




