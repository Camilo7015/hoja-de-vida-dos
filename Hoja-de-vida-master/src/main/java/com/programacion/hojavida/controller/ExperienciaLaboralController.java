package com.programacion.hojavida.controller;

import com.programacion.hojavida.model.ExperienciaLaboral;
import com.programacion.hojavida.repository.ExperienciaLaboralRepository;
import com.programacion.hojavida.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/experiencia")
public class ExperienciaLaboralController {

    @Autowired
    private ExperienciaLaboralRepository experienciaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("experiencia", new ExperienciaLaboral());
        model.addAttribute("personas", personaRepository.findAll());
        return "formulario_experiencia";
    }

    @PostMapping("/guardar")
    public String guardarExperiencia(@ModelAttribute ExperienciaLaboral experiencia) {
        experienciaRepository.save(experiencia);
        return "redirect:/experiencia/lista";
    }

    @GetMapping("/lista")
    public String mostrarLista(Model model) {
        model.addAttribute("experiencias", experienciaRepository.findAll());
        return "lista_experiencias";
    }
}
