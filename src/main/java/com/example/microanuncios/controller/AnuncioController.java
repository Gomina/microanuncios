package com.example.microanuncios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.service.AnuncioService;

@RestController
@RequestMapping("/api/anuncios")
public class AnuncioController {
    
    @Autowired
    AnuncioService anuncioService;

    @GetMapping("/listado_anuncios")
    public ResponseEntity<List<AnuncioDTO>> get_anuncios(){
        if(anuncioService.getAnuncios()==null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(anuncioService.getAnuncios());
    }

    @GetMapping("/{id_anuncio}")
	public ResponseEntity<AnuncioDTO> get_anuncio(@PathVariable("id_anuncio") int id_anuncio){
		if(anuncioService.getAnuncioById(id_anuncio)==null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(anuncioService.getAnuncioById(id_anuncio));
	}

    @GetMapping("/categoria/{id_categoria}")
    public ResponseEntity<List<AnuncioDTO>> get_anuncios_by_categoria(@PathVariable("id_categoria") int id_categoria){
		return ResponseEntity.ok(anuncioService.getAnunciosByCategoria(id_categoria));
	}

    @DeleteMapping("/{id_anuncio}")
    public ResponseEntity<Integer> delete_anuncio(@PathVariable("id_anuncio") int id_anuncio){
        if(anuncioService.getAnuncioById(id_anuncio)==null) {
			return ResponseEntity.ok(1);
		}
		anuncioService.deleteUsuario(id_anuncio);
		return ResponseEntity.ok(0);
    }

    @PostMapping
	public ResponseEntity<Integer>add_anuncio(@RequestBody AnuncioDTO anunciodto){
		AnuncioDTO anuncio = anuncioService.getAnuncioById(anunciodto.getId_anuncio());
		if(anuncio==null) {
			anuncioService.updateAnuncioById(anunciodto);
			return ResponseEntity.ok(0);
		}else {
			return ResponseEntity.ok(1);
		}
	}
	
	@PutMapping
	public ResponseEntity<Integer>update_cliente(@RequestBody AnuncioDTO anunciodto){
		AnuncioDTO anuncio = anuncioService.getAnuncioById(anunciodto.getId_anuncio());
		if(anuncio!=null) {
			anuncioService.updateAnuncioById(anunciodto);
			return ResponseEntity.ok(0);
		}else {
			return ResponseEntity.ok(1);
		}
	}

@	GetMapping("/listado_anuncios/{user}")
	public ResponseEntity<AnuncioDTO> get_anuncio_user(@PathVariable("user") String user){
		if(anuncioService.getAnuncioUser(user) == null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(anuncioService.getAnuncioUser(user));
	}
}
