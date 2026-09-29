package com.example.ecommerce.model;

public class ProductoFisico extends Producto {
    private Double peso;
    private Double dimensiones;

    public ProductoFisico(int id, String nombre, String descripcion, double precio, int stock, Double peso, Double dimensiones){
        super(id, nombre, descripcion, precio, stock);
        setPeso(peso);
        setDimensiones(dimensiones);
    }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) {
        if (peso == null || !Double.isFinite(peso) || peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser un número válido mayor que cero");
        }
        this.peso = peso;
    }

    public Double getDimensiones() { return dimensiones; }
    public void setDimensiones(Double dimensiones) {
        if (dimensiones == null || !Double.isFinite(dimensiones) || dimensiones <= 0) {
            throw new IllegalArgumentException("Las dimensiones deben ser un número válido mayor que cero");
        }
        this.dimensiones = dimensiones;
    }

    @Override
    public String mostrarDetalle() {
        return super.mostrarDetalle()
                + " | Peso: " + peso + " kg"
                + " | Dimensiones: " + dimensiones;
    }
}
