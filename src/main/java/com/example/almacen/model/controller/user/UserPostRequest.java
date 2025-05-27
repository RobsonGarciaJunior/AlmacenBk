package com.example.almacen.model.controller.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data // Lombok para getters/setters
public class UserPostRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Email(message = "El email debe ser válido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    private String foto; // Opcional: Base64 o URL

    @NotNull(message = "El tipo de usuario es obligatorio")
    private String tipoUser; // "USUARIO" o "ADMIN"

    private Boolean habilitado = true; // Valor por defecto

    public UserPostRequest() {
    	
    }
    
	public UserPostRequest(@NotBlank(message = "El nombre es obligatorio") String nombre,
			@NotBlank(message = "El apellido es obligatorio") String apellido,
			@Email(message = "El email debe ser válido") @NotBlank(message = "El email es obligatorio") String email,
			@NotBlank(message = "La contraseña es obligatoria") String password, String foto,
			@NotNull(message = "El tipo de usuario es obligatorio") String tipoUser, Boolean habilitado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.foto = foto;
		this.tipoUser = tipoUser;
		this.habilitado = habilitado;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
    
    
}
