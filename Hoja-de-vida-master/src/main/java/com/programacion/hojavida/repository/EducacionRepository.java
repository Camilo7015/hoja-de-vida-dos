package com.programacion.hojavida.repository;

import com.programacion.hojavida.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {

    // Si quieres obtener las educaciones de una persona específica
    List<Educacion> findByPersonaIdPersona(Long idPersona);
}
