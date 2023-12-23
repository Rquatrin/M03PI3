package com.clinica.clinicaDemo.repository;

import com.clinica.clinicaDemo.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
    
}

