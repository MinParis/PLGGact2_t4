package com.spring2.springboot.controller;

import com.spring2.springboot.dto.ProductoDTO;
import com.spring2.springboot.model.Producto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Controlador MVC (NO REST): todos los métodos regresan nombres de vista
 * Thymeleaf, distinto al RestController de la Actividad 1.
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {

    // @Value: lee una propiedad personalizada desde application.properties
    @Value("${app.nombre-proyecto}")
    private String nombreProyecto;

    // "Base de datos" en memoria solo para esta demo
    private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong();

    public ProductoController() {
        productos.add(new Producto(contadorId.incrementAndGet(), "Laptop Lenovo", "Electronica", 12500.0));
        productos.add(new Producto(contadorId.incrementAndGet(), "Mouse Logitech", "Electronica", 350.0));
        productos.add(new Producto(contadorId.incrementAndGet(), "Silla de oficina", "Muebles", 1800.0));
        productos.add(new Producto(contadorId.incrementAndGet(), "Escritorio", "Muebles", 2200.0));
        productos.add(new Producto(contadorId.incrementAndGet(), "Cuaderno profesional", "Papeleria", 45.0));
    }

    /**
     * a) Vista de lista usando Model + th:each
     * También cumple el requisito de @RequestParam: /productos?categoria=Muebles
     */
    @GetMapping
    public String listar(@RequestParam(required = false) String categoria, Model model) {
        List<Producto> resultado = productos;

        if (categoria != null && !categoria.isBlank()) {
            resultado = productos.stream()
                    .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                    .toList();
        }

        model.addAttribute("productos", resultado);
        model.addAttribute("categoriaSeleccionada", categoria);
        model.addAttribute("nombreProyecto", nombreProyecto);
        return "productos/lista";
    }

    /**
     * Requisito de @PathVariable: detalle de un producto por id
     * Ej: /productos/3
     */
    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Producto producto = productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        model.addAttribute("producto", producto);
        model.addAttribute("nombreProyecto", nombreProyecto);
        return "productos/detalle";
    }

    // Muestra el formulario vacío (GET)
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("productoDTO", new ProductoDTO());
        model.addAttribute("nombreProyecto", nombreProyecto);
        return "productos/formulario";
    }

    /**
     * b) Formulario que usa @ModelAttribute para recibir los datos
     * capturados y procesarlos (los agrega a la lista y los muestra).
     */
    @PostMapping("/nuevo")
    public String procesarFormulario(@ModelAttribute ProductoDTO productoDTO, Model model) {
        Producto nuevo = new Producto(
                contadorId.incrementAndGet(),
                productoDTO.getNombre(),
                productoDTO.getCategoria(),
                productoDTO.getPrecio()
        );
        productos.add(nuevo);

        model.addAttribute("productoDTO", productoDTO);
        model.addAttribute("nombreProyecto", nombreProyecto);
        return "productos/resultado";
    }
}