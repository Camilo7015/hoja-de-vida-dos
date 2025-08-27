package com.programacion.hojavida.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/cv")
    public String verCv() {
        // Renderiza la plantilla estatica de hoja de vida
        return "hoja_vida";
    }
}
