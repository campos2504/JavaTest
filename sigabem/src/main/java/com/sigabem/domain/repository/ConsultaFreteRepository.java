package com.sigabem.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigabem.domain.model.ConsultaFrete;

@Repository
public interface ConsultaFreteRepository extends JpaRepository<ConsultaFrete,Long>{
    
}
