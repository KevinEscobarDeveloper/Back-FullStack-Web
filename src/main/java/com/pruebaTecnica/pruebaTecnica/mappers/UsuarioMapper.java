package com.pruebaTecnica.pruebaTecnica.mappers;

import com.pruebaTecnica.pruebaTecnica.dtos.UsuarioDTO;
import com.pruebaTecnica.pruebaTecnica.entities.Usuario;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UsuarioMapper {

    @Insert("INSERT INTO usuarios (Nombre, Correo, Direccion, RFC) " +
            "values (#{u.nombre}, #{u.correo}, #{u.direccion}, #{u.rfc} );")
    @Options(useGeneratedKeys = true, keyProperty = "u.id")
    Boolean save(@Param("u") Usuario usuario);

    @Select("SELECT * FROM usuarios where Nombre = #{name};")
    Usuario getByName(String name);

    @Select("SELECT * FROM usuarios;")
    Usuario[] getAll();

    @Delete("DELETE FROM usuarios WHERE Nombre = #{name}")
    Boolean deleteByName(String name);
}
