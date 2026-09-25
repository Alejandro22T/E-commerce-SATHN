package com.example.ecommerce.model;

public class ProductoDigital extends Producto{

    private String tipoLicencia;
    private String urlPlataforma;

    public ProductoDigital(int id, String nombre, String descripcion, double precio, int stock,String tipoLicencia, String urlPlataforma){
        super( id, nombre, descripcion, precio, stock );
        this.tipoLicencia = tipoLicencia;
        this.urlPlataforma = urlPlataforma;
    }

    public String getTipoLicencia() { return tipoLicencia; }
    public void setTipoLicencia(String tipoLicencia) {  this.tipoLicencia = tipoLicencia; }

    public String getUrlPlataforma() { return urlPlataforma; }
    public void setUrlPlataforma(String urlPlataforma) {  this.urlPlataforma = urlPlataforma; }
}
