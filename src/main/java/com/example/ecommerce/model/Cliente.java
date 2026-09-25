package com.example.ecommerce.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Usuario que compra productos en la tienda.
 */
public class Cliente extends Usuario {

    private final List<Producto> historialCompras;
    private final List<String> preferencias;

    public Cliente(int id, String nombre, String correoElectronico, String contrasena) {
        super(id, nombre, correoElectronico, contrasena);
        this.historialCompras = new ArrayList<>();
        this.preferencias = new ArrayList<>();
    }

    public Cliente() {
        this.historialCompras = new ArrayList<>();
        this.preferencias = new ArrayList<>();
    }

    public void registrarCompra(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        historialCompras.add(producto);
    }

    public void agregarPreferencia(String preferencia) {
        if (preferencia == null || preferencia.isBlank()) {
            throw new IllegalArgumentException("La preferencia no puede estar vacía");
        }
        if (!preferencias.contains(preferencia)) {
            preferencias.add(preferencia);
        }
    }

    public void eliminarPreferencia(String preferencia) {
        preferencias.remove(preferencia);
    }

    public List<Producto> getHistorialCompras() {
        return Collections.unmodifiableList(historialCompras);
    }

    public List<String> getPreferencias() {
        return Collections.unmodifiableList(preferencias);
    }
}
