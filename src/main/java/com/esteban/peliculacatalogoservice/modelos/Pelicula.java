package com.esteban.peliculacatalogoservice.modelos;

public class Pelicula {

    private String peliculaId;
    private String titulo;
    private String desc;



    public Pelicula(){}

    public Pelicula(String peliculaId, String titulo, String desc) {
        this.peliculaId = peliculaId;
        this.titulo = titulo;
        this.desc = desc;
    }

    public String getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(String peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
