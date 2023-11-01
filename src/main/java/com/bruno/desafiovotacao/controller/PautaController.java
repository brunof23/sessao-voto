package com.bruno.desafiovotacao.controller;

import com.bruno.desafiovotacao.models.PautaModel;
import com.bruno.desafiovotacao.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pautas")
public class PautaController {

    @Autowired
    private PautaService pautaService;

    @GetMapping
    public List<PautaModel> listarPautas() {
        return pautaService.listarPautas();
    }

    @PostMapping
    public PautaModel cadastrarPauta(@RequestBody String titulo) {
        return pautaService.cadastrarPauta(titulo);
    }
}