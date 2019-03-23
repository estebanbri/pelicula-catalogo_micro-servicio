package com.esteban.peliculacatalogoservice.componentes;

import com.esteban.peliculacatalogoservice.modelos.CatalogoItem;
import com.esteban.peliculacatalogoservice.modelos.Pelicula;
import com.esteban.peliculacatalogoservice.modelos.Raiting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogos")
public class PeliculaCatalogoRecurso {

    @Autowired
    RestTemplate restTemplate;

    private static final String RATING_DATA_MICROSERVICIO = "RATING-DATA-MICROSERVICIO";
    private static final String PELICULA_INFO_MICROSERVICIO = "PELICULA-INFO-MICROSERVICIO";

    @GetMapping("/{id}")
    public List<CatalogoItem> getCatalogo(@PathVariable("id") String userId){

        /**
         *  CALL: raiting-data-service
         *  Descripcion: obtengo todos los raitings de las peliculas que vio el usuario
         *  INPUT: idUsuario
         *  OUTPUT: Lista<Raitings> asociado al usuario
         */
        ResponseEntity<List<Raiting>> response = restTemplate.exchange("http://"+RATING_DATA_MICROSERVICIO+"/raitings/usuario/"+userId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Raiting>>() {});

        List<Raiting> raitings = response.getBody();


        List<CatalogoItem> catalogoItems = raitings.stream()
                .map( raiting -> {
                    /**
                     *  CALL: pelicula-info-service
                     *  Descripcion: obtengo los details de las peliculas que vio el usuario (esto ultimo obtenido del call al microservicio raiting-data-servicio
                     *  INPUT: idPelicula
                     *  OUTPUT: Lista<Pelicula> asociado al idPelicula, es decir el details de la peli
                     */
                    Pelicula pelicula = restTemplate.getForObject("http://"+PELICULA_INFO_MICROSERVICIO+"/peliculas/"+ raiting.getIdPelicula(), Pelicula.class);

                    // Armamos el response con los datos obtenidos de los dos call anteriores a los microservicios raiting-data-servicio y pelicula-info-service

                    return new CatalogoItem(pelicula.getTitulo(),pelicula.getDesc(),raiting.getRaiting());
                })
                .collect(Collectors.toList());

        return catalogoItems;
    }
}
