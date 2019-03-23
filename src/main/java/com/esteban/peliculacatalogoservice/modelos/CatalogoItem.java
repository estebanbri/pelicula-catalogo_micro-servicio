package com.esteban.peliculacatalogoservice.modelos;

public class CatalogoItem {

    private String titulo;
    private String desc;
    private Integer rating;

    public CatalogoItem(){}

    public CatalogoItem(String titulo, String desc, Integer rating) {
        this.titulo = titulo;
        this.desc = desc;
        this.rating = rating;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
