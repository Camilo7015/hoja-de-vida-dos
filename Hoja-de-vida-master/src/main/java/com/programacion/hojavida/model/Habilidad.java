package com.programacion.hojavida.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "habilidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidad")
    private Long idHabilidad;

    @Column(nullable = false, length = 50)
    private String habilidad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelHabilidad nivel;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;
}
