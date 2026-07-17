package com.spring2.springboot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DatosController {

    @GetMapping("/Colores")
    public List<String> colores() {
        return List.of(
                "Azul",
                "Morado",
                "Negro",
                "Verde"
        );
    }

    @GetMapping("/Sobremi")
    public List<String> sobreMi() {
        return List.of(
                "Paris Lizette Gomez Garcia",
                "21 años",
                "Estudiante de Ingeniería en Sistemas",
                "22161085"
        );
    }

    @GetMapping("/materias")
    public List<String> materias() {
        return List.of(
                "Programación Web",
                "Base de Datos",
                "Redes",
                "Ingeniería de Software"
        );
    }

}