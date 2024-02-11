package com.pruebaTecnica.pruebaTecnica.controllers;

import com.pruebaTecnica.pruebaTecnica.dtos.UsuarioDTO;
import com.pruebaTecnica.pruebaTecnica.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Select;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> createUsers(@RequestBody UsuarioDTO dto) {
         usuarioService.createUser(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/{name}")
    public ResponseEntity<UsuarioDTO> getByName(@PathVariable(name = "name") String name) {
        UsuarioDTO usuario =usuarioService.getUser(name);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<UsuarioDTO[]> getAll() {
        UsuarioDTO[] usuarios = usuarioService.getAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<UsuarioDTO> deleteUsers(@PathVariable String name) {
        usuarioService.deleteUser(name);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
