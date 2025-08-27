package com.programacion.hojavida.repository;

import com.programacion.hojavida.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {

    List<Habilidad> findByPersonaIdPersona(Long idPersona);
}
