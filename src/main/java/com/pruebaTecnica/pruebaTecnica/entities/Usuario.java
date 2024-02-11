package com.pruebaTecnica.pruebaTecnica.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Usuario {
    private Integer id;
    private String nombre;
    private String correo;
    private String direccion;
    private String  rfc;
}
