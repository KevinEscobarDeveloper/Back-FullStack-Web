package com.pruebaTecnica.pruebaTecnica.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {
    private String nombre;
    private String correo;
    private String direccion;
    private String  rfc;
}
