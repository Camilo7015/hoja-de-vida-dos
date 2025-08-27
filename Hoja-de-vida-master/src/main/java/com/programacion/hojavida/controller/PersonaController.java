package com.programacion.hojavida.controller;

import com.programacion.hojavida.model.Persona;
import com.programacion.hojavida.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    // Mostrar formulario para nueva persona
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("persona", new Persona());
        return "formulario_persona";
    }

    // Guardar persona
    @PostMapping("/guardar")
    public String guardarPersona(@ModelAttribute Persona persona) {
        personaRepository.save(persona);
        return "redirect:/personas/lista";
    }

    // Mostrar lista de personas
    @GetMapping("/lista")
    public String mostrarLista(Model model) {
        model.addAttribute("personas", personaRepository.findAll());
        return "lista_personas";
    }
}
