package org.serratec.serratecmusic.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.serratecmusic.entity.Perfil;
import org.serratec.serratecmusic.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Perfis", description = "Gerenciamento de perfis")
@RestController
@RequestMapping("/perfis")
public class PerfilController {

}