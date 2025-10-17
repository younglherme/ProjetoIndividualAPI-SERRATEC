package org.serratec.serratecmusic.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do usuario é obrigatório!")
    @Column(nullable = false)
    private String nome;

    @Email(message = "Email inválido!")
    @NotBlank(message = "Email é obrigatório")
    @Column
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_perfil")
    @Valid
    private Perfil perfil;

    @OneToMany(mappedBy = "usuario")
    private List<Playlist> playlists;

    public Usuario() {}

    public Usuario(Long id, String nome, String email, Perfil perfil, List<Playlist> playlists) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
        this.playlists = playlists;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}