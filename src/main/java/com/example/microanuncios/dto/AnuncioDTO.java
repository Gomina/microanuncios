package com.example.microanuncios.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AnuncioDTO {
    private int id_anuncio;
    private CategoriaDTO id_categoria;
    private String user;
    private String titulo;
    private String descripcion;
    private double precio;
    private Date fecha_publicacion;
}
