package com.sena.ivan.interfaceService;

import java.util.List;
import java.util.Optional;

import com.sena.ivan.model.usuario;

public interface IUsuarioService {
    public String save(usuario usuario);    
    public List<usuario> findAll();
    public Optional<usuario> findOne(String id);
    public int delete(String id);
    // public List<usuario> filtroUsuario(String filtro);
    public List<usuario> CambiarDocumento();
    public List<usuario> actualizarContraseña(String actualizarContraseña);
    public List<usuario> iniciosesionNotificar(String iniciosesionNotificar);


}
