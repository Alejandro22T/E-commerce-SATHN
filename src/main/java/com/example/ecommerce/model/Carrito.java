package com.example.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;
    private double total;

    // Constructor: Inicializa la lista vacía y el total en 0.0
    public Carrito() {
        this.productos = new ArrayList<>();
        this.total = 0.0;
    }

    // Método para añadir un producto y recalcular el total
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        calcularTotal();
    }

    // Método para remover un producto usando su ID
    public boolean removerProducto(int idProducto) {
        boolean eliminado = this.productos.removeIf(p -> p.getId() == idProducto );
        if (eliminado) {
            calcularTotal();
        }
        return eliminado;
    }

    // Método para calcular el total recorriendo la lista de productos
    public double calcularTotal() {
        this.total = 0.0;
        for (Producto p : this.productos) {
            this.total += p.getPrecio();
        }
        return this.total;
    }

    // Getters
    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }
}
