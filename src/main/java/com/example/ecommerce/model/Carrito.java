package com.example.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Carrito {
    private List<Producto> productos;
    private double total;

    // Constructor: Inicializa la lista vacía y el total en 0.0
    public Carrito() {
        this.productos = new ArrayList<>();
        this.total = 0.0;
    }

    // Metodo para añadir un producto y recalcular el total
    public void agregarProducto(Producto producto) {
        Objects.requireNonNull(producto, "El producto no puede ser nulo");
        this.productos.add(producto);
        calcularTotal();
    }

    // Busca en el catálogo, ya que el carrito por sí solo no puede resolver un ID.
    public void agregarProducto(int idProducto, List<? extends Producto> catalogo) {
        Objects.requireNonNull(catalogo, "El catálogo no puede ser nulo");
        Producto producto = catalogo.stream()
                .filter(candidato -> candidato.getId() == idProducto)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe un producto con ID " + idProducto));
        agregarProducto(producto);
    }

    public void agregarProducto(String nombre, double precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (!Double.isFinite(precio) || precio < 0) {
            throw new IllegalArgumentException("El precio debe ser un número válido no negativo");
        }
        agregarProducto(new Producto(0, nombre, "", precio, 1));
    }

    // Metodo para remover un producto usando su ID
    public boolean removerProducto(int idProducto) {
        boolean eliminado = this.productos.removeIf(p -> p.getId() == idProducto );
        if (eliminado) {
            calcularTotal();
        }
        return eliminado;
    }

    // Metodo para calcular el total recorriendo la lista de productos
    public double calcularTotal() {
        this.total = 0.0;
        for (Producto p : this.productos) {
            this.total += p.getPrecio();
        }
        return this.total;
    }

    public String mostrarDetallesProductos() {
        return productos.stream()
                .map(Producto::mostrarDetalle)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    // Getters
    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }
}
