package com.bruno.desafiovotacao.repository;

import com.bruno.desafiovotacao.models.PautaModel;
import com.bruno.desafiovotacao.models.SessaoVotacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacaoModel, Long> {
    List<SessaoVotacaoModel> findByPauta(PautaModel pauta);
}