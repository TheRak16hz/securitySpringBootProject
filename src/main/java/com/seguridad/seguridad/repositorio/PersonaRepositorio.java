package com.seguridad.seguridad.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seguridad.seguridad.modelo.persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<persona, Integer> {
    
}
