package com.bruno.desafiovotacao.controller;

import com.bruno.desafiovotacao.models.SessaoVotacaoModel;
import com.bruno.desafiovotacao.service.SessaoVotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/sessoes-votacao")
public class SessaoVotacaoController {

    @Autowired
    private SessaoVotacaoService sessaoVotacaoService;

    @PostMapping("/abrir")
    public SessaoVotacaoModel abrirSessaoVotacao(@RequestParam Long pautaId,
                                                 @RequestParam(defaultValue = "1") int duracaoMinutos) {
        LocalDateTime fim = LocalDateTime.now().plusMinutes(duracaoMinutos);
        return sessaoVotacaoService.abrirSessaoVotacao(pautaId, fim);
    }

    @GetMapping("/{sessaoId}/resultado")
    public String obterResultadoVotacao(@PathVariable Long sessaoId) {
        return sessaoVotacaoService.obterResultadoVotacao(sessaoId);
    }
}