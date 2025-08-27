package com.programacion.hojavida.controller;

import com.programacion.hojavida.model.Educacion;
import com.programacion.hojavida.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/educaciones")
public class EducacionController {

    @Autowired
    private EducacionRepository educacionRepository;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("educacion", new Educacion());
        return "formulario_educacion";
    }

    @PostMapping("/guardar")
    public String guardarEducacion(@ModelAttribute Educacion educacion) {
        educacionRepository.save(educacion);
        return "redirect:/educaciones/lista";
    }

    @GetMapping("/lista")
    public String mostrarLista(Model model) {
        model.addAttribute("educaciones", educacionRepository.findAll());
        return "lista_educaciones";
    }
}
