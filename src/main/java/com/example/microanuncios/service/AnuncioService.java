package com.example.microanuncios.service;

import java.util.List;

import com.example.microanuncios.dto.AnuncioDTO;

public interface AnuncioService {
    
    public List<AnuncioDTO> getAnuncios();
    public AnuncioDTO getAnuncioById(int id_anuncio);
    public List<AnuncioDTO> getAnunciosByCategoria(int id_categoria);
    public void deleteUsuario(int id_anuncio);
    public void updateAnuncioById(AnuncioDTO anunciodto);
    public AnuncioDTO getAnuncioUser(String user);
}
