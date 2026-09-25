package com.example.ecommerce.model;

public class ProductoFisico extends Producto {
    private Double peso;
    private Double dimensiones;

    public ProductoFisico(int id, String nombre, String descripcion, double precio, int stock, Double peso, Double dimensiones){
        super(id, nombre, descripcion, precio, stock);
        this.peso = peso;
        this.dimensiones = dimensiones;
    }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public Double getDimensiones() { return dimensiones; }
    public void setDimensiones(Double dimensiones) { this.dimensiones = dimensiones; }
}
