package org.serratec.serratecmusic.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.serratecmusic.entity.Musica;
import org.serratec.serratecmusic.entity.Playlist;
import org.serratec.serratecmusic.entity.Usuario;
import org.serratec.serratecmusic.repository.MusicaRepository;
import org.serratec.serratecmusic.repository.PlaylistRepository;
import org.serratec.serratecmusic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Tag(name = "Playlists", description = "Gerenciamento de playlists")
@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private MusicaRepository musicaRepository;

    @PostMapping
    public ResponseEntity<Playlist> criarPlaylist(@RequestBody @Valid Playlist playlist, @RequestParam Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        playlist.setUsuario(usuario);
        Playlist salva = playlistRepository.save(playlist);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Playlist> atualizarMusicas(@PathVariable Long id, @RequestBody List<Long> musicaIds) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Playlist não encontrada"));
        List<Musica> musicas = musicaRepository.findAllById(musicaIds);
        playlist.setMusicas(musicas);
        Playlist salva = playlistRepository.save(playlist);
        return ResponseEntity.ok(salva);
    }
}


