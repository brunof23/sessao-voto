package com.bruno.desafiovotacao.service;

import com.bruno.desafiovotacao.models.PautaModel;
import com.bruno.desafiovotacao.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PautaService {
    @Autowired
    private PautaRepository pautaRepository;

    public PautaModel cadastrarPauta(String titulo) {
        PautaModel novaPauta = new PautaModel();
        novaPauta.setTitulo(titulo);

        return pautaRepository.save(novaPauta);
    }

    public List<PautaModel> listarPautas() {
        return pautaRepository.findAll();
    }
}
