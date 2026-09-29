package com.example.ecommerce.model;

import java.net.URI;
import java.net.URISyntaxException;

public class ProductoDigital extends Producto{

    private String tipoLicencia;
    private String urlPlataforma;

    public ProductoDigital(int id, String nombre, String descripcion, double precio, int stock,String tipoLicencia, String urlPlataforma){
        super( id, nombre, descripcion, precio, stock );
        setTipoLicencia(tipoLicencia);
        setUrlPlataforma(urlPlataforma);
    }

    public String getTipoLicencia() { return tipoLicencia; }
    public void setTipoLicencia(String tipoLicencia) {
        if (tipoLicencia == null || tipoLicencia.isBlank()) {
            throw new IllegalArgumentException("El tipo de licencia no puede estar vacío");
        }
        this.tipoLicencia = tipoLicencia;
    }

    public String getUrlPlataforma() { return urlPlataforma; }
    public void setUrlPlataforma(String urlPlataforma) {
        if (urlPlataforma == null || urlPlataforma.isBlank()) {
            throw new IllegalArgumentException("La URL de la plataforma no puede estar vacía");
        }
        try {
            URI uri = new URI(urlPlataforma);
            String esquema = uri.getScheme();
            if (!uri.isAbsolute() || esquema == null
                    || !(esquema.equalsIgnoreCase("http") || esquema.equalsIgnoreCase("https"))
                    || uri.getHost() == null) {
                throw new IllegalArgumentException("La URL debe ser una dirección HTTP o HTTPS válida");
            }
        } catch (URISyntaxException ex) {
            throw new IllegalArgumentException("La URL de la plataforma no tiene un formato válido", ex);
        }
        this.urlPlataforma = urlPlataforma;
    }

    @Override
    public String mostrarDetalle() {
        return super.mostrarDetalle()
                + " | Tipo de licencia: " + tipoLicencia
                + " | URL de plataforma: " + urlPlataforma;
    }
}
