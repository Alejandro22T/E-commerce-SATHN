package com.example.ecommerce.model;

public class Producto {
    // 1. Attributes
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    // 2. Constructor completo para inicializar el objeto
    public Producto(int id, String nombre, String descripcion, double precio, int stock) {
        this.id = id;
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setStock(stock);
    }

    public Producto() {
    }

    // 4. Métodos Getters y Setters

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        if (!Double.isFinite(precio) || precio < 0) {
            throw new IllegalArgumentException("El precio debe ser un número válido no negativo");
        }
        this.precio = precio;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.stock = stock;
    }

    public String mostrarDetalle() {
        return String.format(
                "Producto: %s | Descripción: %s | Precio: $%.2f | Stock: %d",
                nombre, descripcion, precio, stock);
    }

}
