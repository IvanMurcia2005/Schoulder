package com.sena.ivan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ivan.interfaceService.IUsuarioService;
import com.sena.ivan.interfaces.usuarioInterface;
import com.sena.ivan.model.usuario;

@Service
public class usuarioService implements IUsuarioService {
	
	@Autowired
	private usuarioInterface data;

    @Override
    public String save(usuario usuario) {
        data.save(usuario);
        return usuario.getId();
    }

    @Override
    public List<usuario> findAll() {
        List<usuario> Lista_Usuario=(List<usuario>) data.findAll();
		return Lista_Usuario;
    }

    @Override
    public Optional<usuario> findOne(String id) {
        Optional<usuario> usuario=data.findById(id);
		return usuario;
    }

    @Override
    public int delete(String id) {
        data.deleteById(id);
		return 1;
    }

    @Override
    public List<usuario> CambiarDocumento() {
        List<usuario> Lista_Usuario = data.CambiarDocumento();
        return Lista_Usuario;
    }

    @Override
    public List<usuario> actualizarContraseña(String actualizarContraseña) {
        List<usuario> Lista_Usuario = data.actualizarContraseña(actualizarContraseña);
        return Lista_Usuario;
    }

    @Override
    public List<usuario> iniciosesionNotificar(String iniciosesionNotificar) {
        List<usuario> Lista_Usuario = data.iniciosesionNotificar(iniciosesionNotificar);
        return Lista_Usuario;
    }


}
