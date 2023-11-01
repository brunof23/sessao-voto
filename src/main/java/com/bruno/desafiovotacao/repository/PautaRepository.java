package com.bruno.desafiovotacao.repository;

import com.bruno.desafiovotacao.models.PautaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PautaRepository extends JpaRepository<PautaModel, Long> {
    List<PautaModel> findAll();

}