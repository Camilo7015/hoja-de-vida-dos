package com.programacion.hojavida.repository;

import com.programacion.hojavida.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    // Puedes agregar métodos de consulta personalizados si quieres,
    // como buscar por correo, nombre, etc.
}
