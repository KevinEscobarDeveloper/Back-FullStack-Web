package com.pruebaTecnica.pruebaTecnica.services;

import com.pruebaTecnica.pruebaTecnica.dtos.UsuarioDTO;
import com.pruebaTecnica.pruebaTecnica.entities.Usuario;

public interface UsuarioService {
    void createUser(UsuarioDTO dto);
    UsuarioDTO getUser(String name);
    UsuarioDTO[] getAll();
    void deleteUser(String name);
}
