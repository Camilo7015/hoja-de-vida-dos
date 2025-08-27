package com.programacion.hojavida.repository;

import com.programacion.hojavida.model.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Long> {

    List<ExperienciaLaboral> findByPersonaIdPersona(Long idPersona);
}
