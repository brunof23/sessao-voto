package com.bruno.desafiovotacao.repository;

import com.bruno.desafiovotacao.models.AssociadoModel;
import com.bruno.desafiovotacao.models.PautaModel;
import com.bruno.desafiovotacao.models.VotoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VotoRepository extends JpaRepository<VotoModel, Long> {
    boolean existsByPautaAndAssociado(PautaModel pauta, AssociadoModel associado);
    List<VotoModel> findAllByPauta(PautaModel pauta);
}
