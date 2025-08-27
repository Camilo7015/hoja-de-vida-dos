package com.programacion.hojavida.controller;

import com.programacion.hojavida.model.Habilidad;
import com.programacion.hojavida.model.NivelHabilidad;
import com.programacion.hojavida.repository.HabilidadRepository;
import com.programacion.hojavida.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/habilidad")
public class HabilidadController {

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("habilidad", new Habilidad());
        model.addAttribute("niveles", NivelHabilidad.values());
        model.addAttribute("personas", personaRepository.findAll());
        return "formulario_habilidad";
    }

    @PostMapping("/guardar")
    public String guardarHabilidad(@ModelAttribute Habilidad habilidad) {
        habilidadRepository.save(habilidad);
        return "redirect:/habilidad/lista";
    }

    @GetMapping("/lista")
    public String mostrarLista(Model model) {
        model.addAttribute("habilidades", habilidadRepository.findAll());
        return "lista_habilidades";
    }
}
