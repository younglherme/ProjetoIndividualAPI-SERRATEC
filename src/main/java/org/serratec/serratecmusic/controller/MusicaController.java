package org.serratec.serratecmusic.controller;

import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.serratec.serratecmusic.DTO.MusicaDTO;
import org.serratec.serratecmusic.entity.Artista;
import org.serratec.serratecmusic.entity.Musica;
import org.serratec.serratecmusic.repository.ArtistaRepository;
import org.serratec.serratecmusic.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Músicas", description = "Gerenciamento de músicas")
@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @PostMapping
    public ResponseEntity<Musica> criarMusica(@RequestBody @Valid MusicaDTO musicaDTO) {
        Musica musica = new Musica();
        musica.setTitulo(musicaDTO.getTitulo());
        musica.setMinutos(musicaDTO.getMinutos());
        musica.setGenero(musicaDTO.getGenero());

        // Buscar artistas pelos IDs fornecidos e associar à música
        List<Artista> artistas = artistaRepository.findAllById(musicaDTO.getArtistaIds());
        if (artistas.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        musica.setArtistas(artistas);

        Musica salva = musicaRepository.save(musica);

        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }
}