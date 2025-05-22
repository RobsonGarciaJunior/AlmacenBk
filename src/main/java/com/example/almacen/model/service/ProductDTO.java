package com.example.almacen.model.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductDTO {
	
	private Integer id;
	private String nombre;
	private String foto;
	private Boolean habilitado;
	
	public ProductDTO(Integer id2, String nombre2, String foto2, Boolean habilitado2) {
		this.id = id2;
		this.nombre = nombre2;
		this.foto = foto2;
		this.habilitado = habilitado2;
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
