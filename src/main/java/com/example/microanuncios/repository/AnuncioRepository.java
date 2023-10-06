package com.example.microanuncios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.microanuncios.model.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer>{
    @Query(nativeQuery = true, value = "SELECT * FROM anuncios WHERE id_categoria = :id_categoria")
    public List<Anuncio> findAnunciosByCategoria(int id_categoria);

    @Query(nativeQuery = true, value = "SELECT * FROM anuncios WHERE user = :user")
    public Anuncio findAnuncioByUser(String user);
}
