package com.example.almacen.model.service;

import lombok.Data;

@Data
public class ProductoStockDTO {
    private Integer productoId;
    private String nombreProducto;
    private String fotoProducto;
    private Integer almacenId;
    private String nombreAlmacen;
    private Integer cantidad;
    private Integer cantidadMin;
    private Boolean habilitado;
    
    public ProductoStockDTO() {
    	
    }
	public ProductoStockDTO(Integer productoId, String nombreProducto, String fotoProducto, Integer almacenId,
			String nombreAlmacen, Integer cantidad, Integer cantidadMin, Boolean habilitado) {
		super();
		this.productoId = productoId;
		this.nombreProducto = nombreProducto;
		this.fotoProducto = fotoProducto;
		this.almacenId = almacenId;
		this.nombreAlmacen = nombreAlmacen;
		this.cantidad = cantidad;
		this.cantidadMin = cantidadMin;
		this.habilitado = habilitado;
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
	public Integer getCantidadMin() {
		return cantidadMin;
	}
	public void setCantidadMin(Integer cantidadMin) {
		this.cantidadMin = cantidadMin;
	}
	public Boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
    
    
}
