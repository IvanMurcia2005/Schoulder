package com.sena.ivan.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.ivan.model.usuario;

@Repository
public interface usuarioInterface extends CrudRepository<usuario,String> {
    @Query ("SELECT u FROM usuario u WHERE TIMESTAMPDIFF(YEAR, u.fecha_nacimiento, NOW())>=18 AND tipo_Documento = 'ti'")
    List<usuario> CambiarDocumento();

    @Query("SELECT u FROM usuario u WHERE  DATEDIFF(NOW(), u.ultima_contraseña) >= 1")
    List<usuario> actualizarContraseña(String actualizarContraseña);

    @Query("SELECT u FROM usuario u WHERE  DATEDIFF(NOW(), u.ultimo_inicio) >= 30")
    List<usuario> iniciosesionNotificar(String iniciosesionNotificar);

}
