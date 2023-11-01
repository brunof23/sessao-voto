package com.bruno.desafiovotacao.controller;

import com.bruno.desafiovotacao.models.AssociadoModel;
import com.bruno.desafiovotacao.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/associados")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @GetMapping
    public List<AssociadoModel> listarAssociados() {
        return associadoService.listarAssociados();
    }

    @GetMapping("/{associadoId}")
    public AssociadoModel consultarAssociado(@PathVariable Long associadoId) {
        return associadoService.consultarAssociado(associadoId);
    }

    @PostMapping
    public AssociadoModel cadastrarAssociado(@RequestBody String nome) {
        return associadoService.cadastrarAssociado(nome);
    }
}
