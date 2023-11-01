package com.bruno.desafiovotacao.service;

import com.bruno.desafiovotacao.models.AssociadoModel;
import com.bruno.desafiovotacao.models.PautaModel;
import com.bruno.desafiovotacao.models.VotoModel;
import com.bruno.desafiovotacao.repository.AssociadoRepository;
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

    @Autowired
    private AssociadoRepository associadoRepository;

    public VotoModel votar(Long pautaId, Long associadoId, boolean voto) {
        PautaModel pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new RuntimeException("Pauta não encontrada"));

        AssociadoModel associado = associadoRepository.findById(associadoId)
                .orElseThrow(() -> new RuntimeException("Associado não encontrado"));

        // Verifica se o associado já votou nessa pauta
        if (votoRepository.existsByPautaAndAssociado(pauta, associado)) {
            throw new RuntimeException("Associado já votou nesta pauta");
        }

        VotoModel novoVoto = new VotoModel();
        novoVoto.setPauta(pauta);
        novoVoto.setAssociado(associado);
        novoVoto.setVoto(voto);

        return votoRepository.save(novoVoto);
    }
}




