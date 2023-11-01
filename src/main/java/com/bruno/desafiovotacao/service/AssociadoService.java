package com.bruno.desafiovotacao.service;

import com.bruno.desafiovotacao.models.AssociadoModel;
import com.bruno.desafiovotacao.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociadoService {

    @Autowired
    private AssociadoRepository associadoRepository;

    public List<AssociadoModel> listarAssociados() {
        return associadoRepository.findAll();
    }

    public AssociadoModel consultarAssociado(Long associadoId) {
        return associadoRepository.findById(associadoId)
                .orElseThrow(() -> new RuntimeException("Associado não encontrado"));
    }

    public AssociadoModel cadastrarAssociado(String nome) {
        AssociadoModel novoAssociado = new AssociadoModel();
        novoAssociado.setNome(nome);
        // Implemente qualquer lógica de inicialização, se necessário
        return associadoRepository.save(novoAssociado);
    }
}

