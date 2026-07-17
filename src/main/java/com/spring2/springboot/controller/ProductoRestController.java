package com.spring2.springboot.controller;

import com.spring2.springboot.dto.ProductoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint REST (regresa JSON), separado del RestController de la Actividad 1.
 * Sirve para probar el DTO desde Postman/Bruno.
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    // POST http://localhost:8080/api/mvc/productos
    @PostMapping
    public ResponseEntity<ProductoDTO> recibirProducto(@RequestBody ProductoDTO productoDTO) {
        System.out.println("Producto recibido vía POST: " + productoDTO.getNombre());
        return new ResponseEntity<>(productoDTO, HttpStatus.CREATED);
    }
}