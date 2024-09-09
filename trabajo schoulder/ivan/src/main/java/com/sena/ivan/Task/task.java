package com.sena.ivan.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sena.ivan.model.usuario;
import com.sena.ivan.service.emailService;
import com.sena.ivan.service.usuarioService;

@Component
public class task {

     @Autowired
    private usuarioService data;

    @Autowired
    private emailService email;

    @Scheduled(fixedRate = 90000)
    public void sendNotificationcron() {
        var Lista_Usuario=data.CambiarDocumento();
        for (usuario usuario : Lista_Usuario) {
            System.out.println("usuario que requiere actualizar documento "+ 
            usuario.getNombre_usuario());
            email.CambiarDocumento(usuario);
        }
    }

    @Scheduled(fixedDelay = 1600000) // Cada 30 minutos  
    public void Notificacion_contraseña() {
        var Lista_Usuario = data.actualizarContraseña("");
        for (usuario usuario : Lista_Usuario) {
            System.out.println("Usuario que requiere actualizar contraseña: " + usuario.getNombre_usuario());
            email.actualizarContraseña(usuario.getCorreo());
        }
    }


    @Scheduled(fixedDelay = 1600000) 
    public void Notificacion_inicioSesion() {
        var Lista_Usuario = data.iniciosesionNotificar("");
        for (usuario usuario : Lista_Usuario) {
            System.out.println("Usuario bloqueado: " + usuario.getNombre_usuario());
            email.iniciosesionNotificar(usuario.getCorreo());
        }
    }
}
