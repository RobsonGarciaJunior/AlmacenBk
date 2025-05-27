package com.example.almacen.model.persistence;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AlmacenProductoId implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3078835058366479368L;
	
    @Column(name = "ALMACEN_ID")
	private Integer almacenId;
    
    @Column(name = "PRODUCTO_ID")
    private Integer productoId;

    public AlmacenProductoId() {
    }

    public AlmacenProductoId(Integer almacenId, Integer productoId) {
        this.almacenId = almacenId;
        this.productoId = productoId;
    }

    public Integer getAlmacenId() {
        return almacenId;
    }

    public void setAlmacenId(Integer almacenId) {
        this.almacenId = almacenId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlmacenProductoId)) return false;
        AlmacenProductoId that = (AlmacenProductoId) o;
        return Objects.equals(almacenId, that.almacenId) &&
               Objects.equals(productoId, that.productoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(almacenId, productoId);
    }
}
