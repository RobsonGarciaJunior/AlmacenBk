package com.example.almacen.model.controller.product;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductGetResponse {

	private Integer id;
	private String nombre;
	private String foto;
	private Boolean habilitado;
	
	public ProductGetResponse(Integer id, String nombre, String foto, Boolean habilitado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.habilitado = habilitado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
}
