package com.spring2.springboot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EjemploController {

    @GetMapping("/detalles_info")
    public String detallesInfo() {
        return "Servidor en linea";
    }
    
}
