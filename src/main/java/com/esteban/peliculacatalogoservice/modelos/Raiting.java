package com.esteban.peliculacatalogoservice.modelos;

public class Raiting {

    private String idPelicula;
    private Integer raiting;

    public Raiting() {
    }

    public Raiting(String idPelicula, Integer raiting) {
        this.idPelicula = idPelicula;
        this.raiting = raiting;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Integer getRaiting() {
        return raiting;
    }

    public void setRaiting(Integer raiting) {
        this.raiting = raiting;
    }
}
