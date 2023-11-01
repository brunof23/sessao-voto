package com.bruno.desafiovotacao.repository;

import com.bruno.desafiovotacao.models.PautaModel;
import com.bruno.desafiovotacao.models.VotoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VotoRepository extends JpaRepository<VotoModel, Long> {
    List<VotoModel> findAllByPauta(PautaModel pauta);
}
