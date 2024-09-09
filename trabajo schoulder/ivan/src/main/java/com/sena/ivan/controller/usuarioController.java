package com.sena.ivan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.ivan.interfaceService.IUsuarioService;
import com.sena.ivan.model.usuario;
import com.sena.ivan.service.emailService;

@RestController
@RequestMapping("/api/v1/usuario")
public class usuarioController {
    
    @Autowired
	private IUsuarioService usuarioService;

    @Autowired
    private emailService emailService;

    @PostMapping("/")
    public ResponseEntity<Object> save (@ModelAttribute("usuario") usuario usuario){
        usuarioService.save(usuario);
        emailService.Bienvenida(usuario.getCorreo());
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        var Lista_Usuario =usuarioService.findAll();
        return new ResponseEntity<>(Lista_Usuario, HttpStatus.OK);
    }


    @GetMapping("/{id_usuario}")
    public ResponseEntity<Object> findOne(@PathVariable("id_usuario") String id){
        var usuario = usuarioService.findOne(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
	
    @GetMapping("/maxima_edad")
    public ResponseEntity<Object> findEdad() {
        var Lista_Usuario = usuarioService.CambiarDocumento();
        return new ResponseEntity<>(Lista_Usuario, HttpStatus.OK);
    }

	@DeleteMapping("/{id_usuario}")
    public ResponseEntity<Object> delete(@PathVariable("id_usuario") String id_usuario){
        usuarioService.delete(id_usuario);
        return new ResponseEntity<>("El registro fue eliminado", HttpStatus.OK);
    }

    @PutMapping("/{id_usuario}")
    public ResponseEntity<Object> update(@PathVariable("id_usuario") String id_usuario, @ModelAttribute usuario usuarioUpdate){
	    var usuario = usuarioService.findOne(id_usuario).orElse(null);
	    if (usuario != null) {
            usuario.setNombre_usuario(usuarioUpdate.getNombre_usuario());
	        usuario.setCorreo(usuarioUpdate.getCorreo());
	        usuario.setTipo_Documento(usuarioUpdate.getTipo_Documento());
            usuario.setDocumento(usuarioUpdate.getDocumento());
            usuario.setFecha_nacimiento(usuarioUpdate.getFecha_nacimiento());
            usuario.setContraseña(usuarioUpdate.getContraseña());
            usuario.setEstado(usuarioUpdate.getEstado());
            usuario.setUltimo_inicio(usuarioUpdate.getUltimo_inicio());
            usuario.setUltima_contraseña(usuarioUpdate.getUltima_contraseña());


	        
	        usuarioService.save(usuario);
	        return new ResponseEntity<>("Guardado", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Error: usuario no encontrado", HttpStatus.BAD_REQUEST);
	    }
	}


}
