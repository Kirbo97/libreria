package com.aluracursos.screenmatch.model;

// la libreria de jackson se implementa añadiendo su codigo en el pom.xml en la seccion de dependencia
// dicho codigo se obtiene de la pagina https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List; //importo la libreria para usar listas

@JsonIgnoreProperties(ignoreUnknown = true) //ignora los campos que no se especificaron aqui
//@JsonAlias es una funcion para dal un alias para indicar que la V lo referencie con el alias

public record DatosLibros(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> datosdelautor,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Integer numeroDeDescargas
) {
    public DatosLibros {
        if (datosdelautor.size() == 0) {
            datosdelautor.add(new DatosAutor("NULL", 0, 0));
        }
    }

}
