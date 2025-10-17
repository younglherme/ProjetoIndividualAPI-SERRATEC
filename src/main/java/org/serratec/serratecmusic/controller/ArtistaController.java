package org.serratec.serratecmusic.controller;

import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.serratec.serratecmusic.entity.Artista;
import org.serratec.serratecmusic.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Artistas", description = "Gerenciamento de artistas")
@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaRepository artistaRepository;

    @PostMapping
    public ResponseEntity<Artista> criarArtista(@RequestBody @Valid Artista artista) {
        Artista salvo = artistaRepository.save(artista);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}