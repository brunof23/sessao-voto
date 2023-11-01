package com.bruno.desafiovotacao.repository;
import com.bruno.desafiovotacao.models.AssociadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AssociadoRepository extends JpaRepository<AssociadoModel, Long> {
    Optional<AssociadoModel> findById(Long associadoId);
}