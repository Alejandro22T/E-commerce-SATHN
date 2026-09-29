# Sistema E-Commerce en Java (Prueba de Concepto - POO)

## Descripción del Proyecto
Este proyecto es una aplicación desarrollada en **Java** con **Spring Boot** para modelar la lógica base de un sistema de comercio electrónico. Aplica los principios fundamentales de la **Programación Orientada a Objetos (POO)** como encapsulamiento, composición, modularidad y herencia para gestionar usuarios, productos y carritos de compras, a través de la herencia permite diferenciar servicios digitales (SaaS/Software) de servicios de infraestructura presencial (Mantenimiento/Redes), así como categorizar a los usuarios entre clientes y administradores

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
src/main/java/com/example/ecommerce/
├── model/
│   ├── Producto.java              # Superclase base para la oferta de la empresa
│   ├── ProductoDigital.java       # Subclase: Licencias Cloud, SaaS, Software
│   ├── ProductoFisico.java        # Subclase: Mantenimiento de Data Centers, Redes
│   ├── Usuario.java               # Superclase base para los actores del sistema
│   ├── Cliente.java               # Subclase: Clientes corporativos
│   ├── Administrador.java         # Subclase: Personal de ingeniería de SATHN
│   └── Carrito.java               # Gestión transaccional y agregación de servicios
└── EcommerceApplication.java      # Punto de entrada y runner de consola para pruebas
```

## Polimorfismo y sobreescritura
`ProductoDigital` y `ProductoFisico` heredan de `Producto`. El carrito recibe
ambos a través de `agregarProducto(Producto)` y `mostrarDetallesProductos()`
invoca `mostrarDetalle()` de cada instancia, mostrando los detalles específicos
mediante sobreescritura.

El carrito también sobrecarga `agregarProducto` para recibir un producto por
ID junto con su catálogo (`agregarProducto(int, List<? extends Producto>)`), o
crear una entrada indicando nombre y precio
(`agregarProducto(String, double)`).

## Encapsulamiento, validaciones y abstracción

Los atributos de `Producto`, `Usuario`, `Carrito` y sus clases derivadas son
privados. El acceso y las modificaciones se realizan mediante métodos públicos,
que validan los datos antes de guardarlos:

* `Producto` rechaza nombres vacíos, precios negativos o no finitos y stock
  negativo. `ProductoFisico` requiere peso y dimensiones positivos;
  `ProductoDigital` requiere una licencia y una URL HTTP o HTTPS válida.
* `Usuario` valida que el nombre y la contraseña no estén vacíos y que el correo
  tenga un formato válido. La contraseña no se expone mediante un getter.
* `Carrito` protege su colección: `getProductos()` devuelve una copia no
  modificable, y agregar o quitar elementos se hace mediante los métodos del
  carrito. `getTotal()` calcula el importe con los precios actuales de los
  productos.

La abstracción de productos se implementa mediante `Producto` como clase base
con los atributos comunes (ID, nombre, descripción, precio y stock).
`ProductoDigital` y `ProductoFisico` heredan esos datos y mantienen sus
propiedades específicas. Ambas sobrescriben `mostrarDetalle()` para presentar
su información particular.

Las pruebas automatizadas se pueden ejecutar con:

```bash
./mvnw test
```

<img width="865" height="861" alt="captura" src="https://github.com/user-attachments/assets/baf07aa7-bb5b-4670-b458-7474d304f29e" />
