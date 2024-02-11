package com.pruebaTecnica.pruebaTecnica.services.impl;

import com.pruebaTecnica.pruebaTecnica.dtos.UsuarioDTO;
import com.pruebaTecnica.pruebaTecnica.entities.Usuario;
import com.pruebaTecnica.pruebaTecnica.exeptions.UserCreationException;
import com.pruebaTecnica.pruebaTecnica.mappers.UsuarioMapper;
import com.pruebaTecnica.pruebaTecnica.services.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
@Log4j2
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper usuarioMapper;

    @Override
    public void createUser(UsuarioDTO dto) {

        log.info(dto.toString());
        Usuario usuario = Usuario.builder()
                .correo(dto.getCorreo())
                .direccion(dto.getDireccion())
                .nombre(dto.getNombre())
                .rfc(dto.getRfc())
                .build();

        Boolean result = usuarioMapper.save(usuario);
        if (result.equals(Boolean.FALSE))
            throw new UserCreationException("No se pudo crear el usuario");
    }

    @Override
    public UsuarioDTO getUser(String name) {
        Usuario result = usuarioMapper.getByName(name);
        if(result ==null)
            throw new UserCreationException("No existe el nombre del usuario en la BBDD");

        return UsuarioDTO.builder()
                .nombre(result.getNombre())
                .correo(result.getCorreo())
                .direccion(result.getDireccion())
                .rfc(result.getRfc())
                .build();

    }

    @Override
    public UsuarioDTO[] getAll() {

        Usuario[] usuarios = usuarioMapper.getAll();

        UsuarioDTO[] usuarioDTOs = Arrays.stream(usuarios)
                .map(this::convertirAUsuarioDTO)
                .toArray(UsuarioDTO[]::new);

        return usuarioDTOs;
    }

    @Override
    public void deleteUser(String name) {
        Boolean result = usuarioMapper.deleteByName(name);
        if(result.equals(Boolean.FALSE))
            throw new UserCreationException("El usuario no se ha podido eliminar");
    }

    private UsuarioDTO convertirAUsuarioDTO(Usuario usuario) {
        // Utilizar el patrón Builder para crear una instancia de UsuarioDTO
        return UsuarioDTO.builder()
                .nombre(usuario.getNombre())
                .correo(usuario.getCorreo())
                .direccion(usuario.getDireccion())
                .rfc(usuario.getRfc())
                .build();
    }

}
