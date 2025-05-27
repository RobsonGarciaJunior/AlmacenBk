package com.example.almacen.model.controller.almacen;

import lombok.Data;

@Data
public class ProductoStockGetResponse {
    private Integer productoId;
    private String nombreProducto;
    private String fotoProducto;
    private Integer almacenId;
    private String nombreAlmacen;
    private Integer cantidad;
    private Integer cantidadMinima;
    private Boolean habilitado;
    private Boolean necesitaReposicion; // Campo calculado: cantidad <= cantidadMinima
    
    public ProductoStockGetResponse() {
    	
    }
	public ProductoStockGetResponse(Integer productoId, String nombreProducto, String fotoProducto, Integer almacenId,
			String nombreAlmacen, Integer cantidad, Integer cantidadMinima, Boolean habilitado,
			Boolean necesitaReposicion) {
		super();
		this.productoId = productoId;
		this.nombreProducto = nombreProducto;
		this.fotoProducto = fotoProducto;
		this.almacenId = almacenId;
		this.nombreAlmacen = nombreAlmacen;
		this.cantidad = cantidad;
		this.cantidadMinima = cantidadMinima;
		this.habilitado = habilitado;
		this.necesitaReposicion = necesitaReposicion;
	}
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getFotoProducto() {
		return fotoProducto;
	}
	public void setFotoProducto(String fotoProducto) {
		this.fotoProducto = fotoProducto;
	}
	public Integer getAlmacenId() {
		return almacenId;
	}
	public void setAlmacenId(Integer almacenId) {
		this.almacenId = almacenId;
	}
	public String getNombreAlmacen() {
		return nombreAlmacen;
	}
	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getCantidadMinima() {
		return cantidadMinima;
	}
	public void setCantidadMinima(Integer cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}
	public Boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	public Boolean getNecesitaReposicion() {
		return necesitaReposicion;
	}
	public void setNecesitaReposicion(Boolean necesitaReposicion) {
		this.necesitaReposicion = necesitaReposicion;
	}
    
    
}