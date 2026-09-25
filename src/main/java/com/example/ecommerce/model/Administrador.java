package com.example.ecommerce.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Usuario encargado de administrar el catálogo y las promociones.
 */
public class Administrador extends Usuario {

    private final List<Producto> inventario;
    private final Map<Integer, Double> promociones;

    public Administrador(int id, String nombre, String correoElectronico, String contrasena) {
        super(id, nombre, correoElectronico, contrasena);
        this.inventario = new ArrayList<>();
        this.promociones = new LinkedHashMap<>();
    }

    public Administrador() {
        this.inventario = new ArrayList<>();
        this.promociones = new LinkedHashMap<>();
    }

    public void agregarProductoAlInventario(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (buscarProducto(producto.getId()) == null) {
            inventario.add(producto);
        }
    }

    public boolean eliminarProductoDelInventario(int idProducto) {
        boolean eliminado = inventario.removeIf(producto -> producto.getId() == idProducto);
        if (eliminado) {
            promociones.remove(idProducto);
        }
        return eliminado;
    }

    public boolean actualizarStock(int idProducto, int nuevoStock) {
        if (nuevoStock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        Producto producto = buscarProducto(idProducto);
        if (producto == null) {
            return false;
        }
        producto.setStock(nuevoStock);
        return true;
    }

    public void establecerPromocion(int idProducto, double porcentajeDescuento) {
        if (buscarProducto(idProducto) == null) {
            throw new IllegalArgumentException("El producto no existe en el inventario");
        }
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");
        }
        promociones.put(idProducto, porcentajeDescuento);
    }

    public void retirarPromocion(int idProducto) {
        promociones.remove(idProducto);
    }

    public double obtenerPrecioPromocional(int idProducto) {
        Producto producto = buscarProducto(idProducto);
        if (producto == null) {
            throw new IllegalArgumentException("El producto no existe en el inventario");
        }
        double descuento = promociones.getOrDefault(idProducto, 0.0);
        return producto.getPrecio() * (1 - descuento / 100);
    }

    public List<Producto> getInventario() {
        return Collections.unmodifiableList(inventario);
    }

    public Map<Integer, Double> getPromociones() {
        return Collections.unmodifiableMap(promociones);
    }

    private Producto buscarProducto(int idProducto) {
        return inventario.stream()
                .filter(producto -> producto.getId() == idProducto)
                .findFirst()
                .orElse(null);
    }
}
