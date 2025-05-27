package com.example.almacen.model.controller.user;

public class UserGetResponse {
    private Integer id;
    private String email;
    private String nombre;
    private String apellido;
    private String foto;
    private Boolean habilitado;
    private String tipoUser;

    // Constructor por defecto
    public UserGetResponse() {
    }

    // Constructor con parámetros
    public UserGetResponse(Integer id, String email, String nombre, String apellido, String foto, Boolean habilitado, String tipoUser) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
        this.habilitado = habilitado;
        this.tipoUser = tipoUser;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
}
