package com.example.microanuncios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.dto.CategoriaDTO;
import com.example.microanuncios.model.Anuncio;
import com.example.microanuncios.model.Categoria;
import com.example.microanuncios.repository.AnuncioRepository;

@Service
public class AnuncioServiceImpl implements AnuncioService{
    @Autowired 
    AnuncioRepository anuncioRepository;

    @Override
    public AnuncioDTO getAnuncioById(int id_anuncio) {
        Anuncio anuncio = anuncioRepository.findById(id_anuncio).orElse(null);
        if(anuncio != null){
            AnuncioDTO anunciodto = new AnuncioDTO();
            Categoria categoria = anuncio.getCategoria();
            CategoriaDTO categoriadto = new CategoriaDTO(categoria.getId_categoria(), categoria.getDescripcion());
            System.out.println(categoriadto);
            anunciodto.setId_anuncio(id_anuncio);
            anunciodto.setId_categoria(categoriadto);
            anunciodto.setUser(anuncio.getUser());
            anunciodto.setTitulo(anuncio.getTitulo());
            anunciodto.setDescripcion(anuncio.getDescripcion());
            anunciodto.setPrecio(anuncio.getPrecio());
            anunciodto.setFecha_publicacion(anuncio.getFecha_publicacion());
            return anunciodto;

        } else {
            return null;
        }
    }

    @Override
    public List<AnuncioDTO> getAnuncios() {
        List<Anuncio> anuncios = anuncioRepository.findAll();
        List<AnuncioDTO> anunciosdto = new ArrayList<>();

        for (Anuncio anuncio : anuncios) {
            AnuncioDTO anunciodto = new AnuncioDTO();
            Categoria categoria = anuncio.getCategoria();
            CategoriaDTO categoriadto = new CategoriaDTO(categoria.getId_categoria(), categoria.getDescripcion());
            System.out.println(categoriadto);
            anunciodto.setId_anuncio(anuncio.getId_anuncio());
            anunciodto.setId_categoria(categoriadto);
            anunciodto.setUser(anuncio.getUser());
            anunciodto.setTitulo(anuncio.getTitulo());
            anunciodto.setDescripcion(anuncio.getDescripcion());
            anunciodto.setPrecio(anuncio.getPrecio());
            anunciodto.setFecha_publicacion(anuncio.getFecha_publicacion());

            anunciosdto.add(anunciodto);
        }

        return anunciosdto;
    }

    @Override
    public List<AnuncioDTO> getAnunciosByCategoria(int id_categoria) {
        List<Anuncio> anuncios = anuncioRepository.findAnunciosByCategoria(id_categoria);
        List<AnuncioDTO> anunciosdto = new ArrayList<>();

        if (anuncios.size() != 0) {
            for (Anuncio anuncio : anuncios) {
                AnuncioDTO anunciodto = new AnuncioDTO();
                Categoria categoria = anuncio.getCategoria();
                CategoriaDTO categoriadtoCategoriaDTO = new CategoriaDTO(categoria.getId_categoria(),
                        categoria.getDescripcion());

                anunciodto.setId_anuncio(anuncio.getId_anuncio());
                anunciodto.setId_categoria(categoriadtoCategoriaDTO);
                anunciodto.setUser(anuncio.getUser());
                anunciodto.setTitulo(anuncio.getTitulo());
                anunciodto.setDescripcion(anuncio.getDescripcion());
                anunciodto.setPrecio(anuncio.getPrecio());
                anunciodto.setFecha_publicacion(anuncio.getFecha_publicacion());

                anunciosdto.add(anunciodto);
            }
        }
        return anunciosdto;
    }

    @Override
    public void deleteUsuario(int id_anuncio) {
        anuncioRepository.deleteById(id_anuncio);
    }

    @Override
    public void updateAnuncioById(AnuncioDTO anunciodto){
        Anuncio anuncio = new Anuncio();
        CategoriaDTO categoriadto = anunciodto.getId_categoria();
        Categoria categoria = new Categoria(categoriadto.getId_categoria(), categoriadto.getDescripcion());

        anuncio.setId_anuncio(anunciodto.getId_anuncio());
        anuncio.setCategoria(categoria);
        anuncio.setUser(anunciodto.getUser());
        anuncio.setTitulo(anunciodto.getTitulo());
        anuncio.setDescripcion(anunciodto.getDescripcion());
        anuncio.setFecha_publicacion(anunciodto.getFecha_publicacion());
        anuncio.setPrecio(anunciodto.getPrecio());
        
        anuncioRepository.save(anuncio);
    }
}
