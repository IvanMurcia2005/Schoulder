package com.sena.ivan.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_usuario", nullable = false, length = 36)
    private String id_usuario;

    @Column(name = "nombre_usuario", nullable = false, length = 40)
    private String nombre_usuario;

	@Column(name = "tipo_Documento", nullable = false, length = 20)
    private String tipo_Documento;

    @Column(name = "documento", nullable = false, length = 12)
    private int documento;
    
    @Column(name = "ultima_contraseña", nullable = false)
	private Date ultima_contraseña;
    
    @Column(name = "ultimo_inicio", nullable = false)
	private Date ultimo_inicio;
    
    @Column(name = "fecha_nacimiento", nullable = false)
	private Date fecha_nacimiento;
    
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "contraseña", nullable = false, length = 100)
	private String contraseña;

    @Column(name = "estado", nullable = false, length = 100)
	private String estado;

   
    public usuario() {
    }

    public usuario(String id_usuario, String nombre_usuario, String tipo_Documento, int documento,
            Date ultima_contraseña, Date ultimo_inicio, Date fecha_nacimiento, String correo, String contraseña,
            String estado) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.tipo_Documento = tipo_Documento;
        this.documento = documento;
        this.ultima_contraseña = ultima_contraseña;
        this.ultimo_inicio = ultimo_inicio;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getTipo_Documento() {
        return tipo_Documento;
    }

    public void setTipo_Documento(String tipo_Documento) {
        this.tipo_Documento = tipo_Documento;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public Date getUltima_contraseña() {
        return ultima_contraseña;
    }

    public void setUltima_contraseña(Date ultima_contraseña) {
        this.ultima_contraseña = ultima_contraseña;
    }

    public Date getUltimo_inicio() {
        return ultimo_inicio;
    }

    public void setUltimo_inicio(Date ultimo_inicio) {
        this.ultimo_inicio = ultimo_inicio;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId() {
        return id_usuario;
    }
    



}
