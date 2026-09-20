# Sistema E-Commerce en Java (Prueba de Concepto - POO)

## Descripción del Proyecto
Este proyecto es una aplicación desarrollada en **Java** con **Spring Boot** para modelar la lógica base de un sistema de comercio electrónico. Aplica los principios fundamentales de la **Programación Orientada a Objetos (POO)** como encapsulamiento, composición y modularidad para gestionar usuarios, productos y carritos de compras.

---

## Tecnologías Utilizadas
* **Lenguaje:** Java 21.0.12
* **Framework:** Spring Boot 4.1.1
* **Herramienta de Construcción:** Maven
* **IDE Recomendado:** IntelliJ IDEA

---

## Arquitectura y Estructura de Clases

La aplicación organiza sus clases en el paquete `model` respetando la separación de responsabilidades:

```text
src/main/java/com/tuempresa/ecommerce/
├── model/
│   ├── Producto.java    # Representa los artículos disponibles
│   ├── Usuario.java     # Representa los clientes de la plataforma
│   └── Carrito.java     # Representa la orden/carrito de compras
└── EcommerceApplication.java # Punto de entrada y prueba de consola

![captura.png](../../../img/captura.png)