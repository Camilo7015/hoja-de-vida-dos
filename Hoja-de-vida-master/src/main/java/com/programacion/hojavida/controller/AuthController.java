package com.programacion.hojavida.controller;

import com.programacion.hojavida.model.Usuario;
import com.programacion.hojavida.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String loginForm() {
        return "login"; // templates/login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<Usuario> usuario = usuarioService.login(username, password);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "home"; // templates/home.html
        } else {
            model.addAttribute("error", "Credenciales inválidas");
            return "login";
        }
    }

    @GetMapping("/registro")
    public String registerForm() {
        return "registro"; // templates/registro.html
    }

    @PostMapping("/registro")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        usuarioService.registrar(username, password);
        model.addAttribute("mensaje", "Usuario registrado con éxito");
        return "login";
    }
}
