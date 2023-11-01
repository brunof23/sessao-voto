package com.bruno.desafiovotacao.controller;

import com.bruno.desafiovotacao.models.VotoModel;
import com.bruno.desafiovotacao.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping
    public VotoModel votar(@RequestParam Long pautaId,
                           @RequestParam boolean voto) {
        return votoService.votar(pautaId, voto);
    }
}