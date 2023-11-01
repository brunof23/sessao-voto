package com.bruno.desafiovotacao.service;

import com.bruno.desafiovotacao.models.PautaModel;
import com.bruno.desafiovotacao.models.SessaoVotacaoModel;
import com.bruno.desafiovotacao.models.VotoModel;
import com.bruno.desafiovotacao.repository.PautaRepository;
import com.bruno.desafiovotacao.repository.SessaoVotacaoRepository;
import com.bruno.desafiovotacao.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessaoVotacaoService {

    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Autowired
    private PautaRepository pautaRepository;

    @Autowired
    private VotoRepository votoRepository;

    public SessaoVotacaoModel abrirSessaoVotacao(Long pautaId, LocalDateTime fim) {
        PautaModel pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new RuntimeException("Pauta não encontrada"));

        SessaoVotacaoModel novaSessao = new SessaoVotacaoModel();
        novaSessao.setPauta(pauta);
        novaSessao.setInicio(LocalDateTime.now());
        novaSessao.setFim(fim);

        return sessaoVotacaoRepository.save(novaSessao);
    }
    public String obterResultadoVotacao(Long sessaoId) {
        SessaoVotacaoModel sessao = sessaoVotacaoRepository.findById(sessaoId)
                .orElseThrow(() -> new RuntimeException("Sessão de votação não encontrada"));

        List<VotoModel> votos = votoRepository.findAllByPauta(sessao.getPauta());

        long votosSim = votos.stream().filter(VotoModel::isVoto).count();
        long votosNao = votos.size() - votosSim;

        return "Resultado da votação:\n" +
                "Votos 'Sim': " + votosSim + "\n" +
                "Votos 'Não': " + votosNao;
    }

}