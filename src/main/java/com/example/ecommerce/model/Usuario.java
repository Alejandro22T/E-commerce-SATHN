package com.example.ecommerce.model;

import java.util.regex.Pattern;

public class Usuario {

    private static final Pattern FORMATO_CORREO =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private int id;
    private String nombre;
    private String correoElectronico;
    private String contrasena;

    // Constructor
    public Usuario(int id, String nombre, String correoElectronico, String contrasena) {
        this.id = id;
        setNombre(nombre);
        setCorreoElectronico(correoElectronico);
        setContrasena(contrasena);
    }

    public Usuario() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        if (correoElectronico == null || !FORMATO_CORREO.matcher(correoElectronico).matches()) {
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido");
        }
        this.correoElectronico = correoElectronico;
    }

    public void setContrasena(String contrasena) {
        if (contrasena == null || contrasena.isBlank()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        this.contrasena = contrasena;
    }
}
