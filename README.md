# Spring Boot MVC con Thymeleaf

## Objetivo

Comprender el patrón MVC en Spring Boot usando Thymeleaf para renderizar vistas del lado del servidor, empleando DTO, `@ModelAttribute`, `@RequestParam`, `@PathVariable`, `@Value` y un endpoint REST para recibir datos mediante una petición POST.

---

## Tecnologías utilizadas

- Java 25
- Spring Boot
- Spring Web
- Thymeleaf
- Maven
- Postman
- Visual Studio Code

---

## Funcionalidades implementadas

- Vista con listado de productos usando `th:each`.
- Formulario para registrar productos utilizando `@ModelAttribute`.
- Filtrado de productos mediante `@RequestParam`.
- Consulta de un producto por ID utilizando `@PathVariable`.
- Lectura de propiedades desde `application.properties` mediante `@Value`.
- Endpoint REST POST que recibe un objeto `ProductoDTO` en formato JSON.

---

## Capturas de pantalla

### 1. Listado de productos (th:each)

Se muestra la lista de productos utilizando Thymeleaf y la directiva `th:each`.

![Listado](Capturas\Captura de pantalla 2026-07-17 091537.png)

---

### 2. Formulario (@ModelAttribute)

Formulario para capturar la información de un producto utilizando `@ModelAttribute`.

![Formulario](capturas/formulario.png)

---

### 3. Resultado del formulario

Resultado después de enviar el formulario mostrando los datos capturados.

![Resultado](capturas/resultado.png)

---

### 4. Endpoint con @RequestParam

Ejemplo de filtrado por categoría.

URL utilizada:

```text
http://localhost:8080/productos/buscar?categoria=Tecnología
```

![RequestParam](capturas/requestparam.png)

---

### 5. Endpoint con @PathVariable

Consulta del detalle de un producto mediante su identificador.

URL utilizada:

```text
http://localhost:8080/productos/0
```

![PathVariable](capturas/pathvariable.png)

---

### 6. Lectura de propiedades con @Value

Visualización del nombre del proyecto y del autor obtenidos desde `application.properties`.

![Value](capturas/value.png)

---

### 7. Prueba del endpoint POST en Postman

Petición realizada desde Postman.

**URL**

```text
POST http://localhost:8080/api/productos
```

**Body**

```json
{
    "nombre":"Monitor",
    "categoria":"Tecnología",
    "precio":4500
}
```

**Respuesta**

```json
{
    "nombre":"Monitor",
    "categoria":"Tecnología",
    "precio":4500
}
```

![Postman](capturas/postman.png)

---

## Autor

**Paris Lizette Gómez García**

Ingeniería en Sistemas Computacionales
