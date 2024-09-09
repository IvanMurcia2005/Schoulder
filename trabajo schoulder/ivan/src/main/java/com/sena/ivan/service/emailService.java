package com.sena.ivan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sena.ivan.model.usuario;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public String Bienvenida(String destinatario) {
        try {
            String asunto = "¡Registro exitoso!";
            String cuerpo = ""
                    + "<body style=\"font-family: 'Arial', sans-serif; background-color: #000000; padding: 40px; color: #ffffff;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #333333; padding: 30px; border-radius: 15px; box-shadow: 0 4px 15px rgba(0, 0, 0, 0.5);\">\r\n"
                    + "  <h1 style=\"font-size: 30px; font-weight: bold; color: #ffffff; text-align: center;\">¡Bienvenid@ a nuestra plataforma!</h1>\r\n"
                    + "  <p style=\"font-size: 18px; color: #dcdcdc; text-align: center; margin-top: 20px;\">Tu registro se ha completado con éxito, estamos felices de tenerte aquí.</p>\r\n"
                    + "  <hr style=\"border: 0; border-top: 2px solid #444444; margin: 30px 0;\">\r\n"
                    + "  <p style=\"font-size: 16px; color: #bbbbbb; line-height: 1.8; text-align: center;\">Esperamos que disfrutes de todas las funcionalidades que hemos preparado para ti.</p>\r\n"
                    + "</div>\r\n"
                    + "<div style=\"text-align: center; margin-top: 20px; font-size: 14px; color: #888888;\">\r\n"
                    + "  <p>&copy; 2024. Todos los derechos reservados.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(destinatario, asunto, cuerpo);
            if (retorno) {
                return "se envió correctamente";
            } else {
                return "No se pudo envíar";
            }

        } catch (Exception e) {
            // TODO: handle exception
            return "Error al envíar " + e.getMessage();
        }
    }

    public String CambiarDocumento(usuario usuario) {
        try {
            String asunto = "Es hora de actualizar tu tipo de documento";
            String cuerpo = ""
                    + "<body style=\"font-family: 'Arial', sans-serif; background-color: #000000; padding: 40px; color: #ffffff;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #333333; padding: 30px; border-radius: 15px; box-shadow: 0 4px 15px rgba(0, 0, 0, 0.5);\">\r\n"
                    + "  <h1 style=\"font-size: 28px; font-weight: bold; color: #ffffff; text-align: center;\">¡Hola "
                    + usuario.getNombre_usuario() + "!</h1>\r\n"
                    + "  <p style=\"font-size: 18px; color: #dcdcdc; text-align: center;\">Necesitamos que actualices la información de tu documento.</p>\r\n"
                    + "  <hr style=\"border: 0; border-top: 1px solid #444444; margin: 20px 0;\">\r\n"
                    + "  <p style=\"font-size: 16px; color: #bbbbbb; line-height: 1.6;\">Accede a tu cuenta lo antes posible para completar esta actualización.</p>\r\n"
                    + "  <p style=\"font-size: 16px; color: #bbbbbb; line-height: 1.6;\">Te agradecemos por tu colaboración.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(usuario.getCorreo(), asunto, cuerpo);
            if (retorno) {
                return "se envió correctamente";
            } else {
                return "No se pudo envíar";
            }

        } catch (Exception e) {
            return "Error al envíar " + e.getMessage();
        }
    }

    public String actualizarContraseña(String destinatario) {
        try {
            String asunto = "Es hora de cambiar tu contraseña";
            String cuerpo = ""
                    + "<body style=\"font-family: 'Arial', sans-serif; background-color: #000000; padding: 40px; color: #ffffff;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #333333; padding: 30px; border-radius: 15px; box-shadow: 0 4px 15px rgba(0, 0, 0, 0.5);\">\r\n"
                    + "  <h1 style=\"font-size: 28px; font-weight: bold; color: #ffffff; text-align: center;\">Actualiza tu contraseña</h1>\r\n"
                    + "  <p style=\"font-size: 18px; color: #dcdcdc; text-align: center;\">Por razones de seguridad, te solicitamos que cambies tu contraseña.</p>\r\n"
                    + "  <hr style=\"border: 0; border-top: 1px solid #444444; margin: 20px 0;\">\r\n"
                    + "  <p style=\"font-size: 16px; color: #bbbbbb; line-height: 1.6;\">Accede a tu cuenta y sigue las instrucciones para realizar el cambio a la mayor brevedad posible.</p>\r\n"
                    + "  <p style=\"font-size: 16px; color: #bbbbbb; line-height: 1.6;\">Agradecemos tu pronta acción.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(destinatario, asunto, cuerpo);
            if (retorno) {
                return "se envió correctamente";
            } else {
                return "No se pudo envíar";
            }

        } catch (Exception e) {
            return "Error al envíar " + e.getMessage();
        }
    }

    public String iniciosesionNotificar(String destinatario) {
        try {
            String asunto = "Bloqueo de cuenta por inactividad";
            String cuerpo = ""
                    + "<body style=\"font-family: 'Arial', sans-serif; background-color: #000000; padding: 40px; color: #ffffff;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #333333; padding: 30px; border-radius: 15px; box-shadow: 0 4px 15px rgba(0, 0, 0, 0.5);\">\r\n"
                    + "  <h1 style=\"font-size: 28px; font-weight: bold; color: #ffffff; text-align: center;\">Aviso de Bloqueo de Cuenta</h1>\r\n"
                    + "  <p style=\"font-size: 18px; color: #dcdcdc; text-align: center;\">Tu cuenta ha sido desactivada debido a un período prolongado de inactividad.</p>\r\n"
                    + "  <hr style=\"border: 0; border-top: 1px solid #444444; margin: 20px 0;\">\r\n"
                    + "  <p style=\"font-size: 16px; color: #bbbbbb; line-height: 1.6;\">Agradecemos tu atención a este asunto.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(destinatario, asunto, cuerpo);
            if (retorno) {
                return "se envió correctamente";
            } else {
                return "No se pudo envíar";
            }

        } catch (Exception e) {
            return "Error al envíar " + e.getMessage();
        }
    }

    public boolean enviarCorreo(String destinatario, String asunto, String cuerpo) throws MessagingException {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(cuerpo, true);

            javaMailSender.send(message);
            return true;
        } catch (Exception e) {

            return false;
        }

    }

}
