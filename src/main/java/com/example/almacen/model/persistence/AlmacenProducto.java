package com.example.almacen.model.persistence;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "AlmacenProducto")
public class AlmacenProducto implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AlmacenProductoId id;

    @ManyToOne
    @MapsId("almacenId")   // Mapea el almacenId dentro del EmbeddedId
    @JoinColumn(name = "almacen_id")
    private Almacen almacen;

    @ManyToOne
    @MapsId("productoId")  // Mapea el productoId dentro del EmbeddedId
    @JoinColumn(name = "producto_id")
    private Product producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "cantidadmin")
    private Integer cantidadMin;

    public AlmacenProducto() {
    }

    public AlmacenProducto(AlmacenProductoId id, Almacen almacen, Product producto, Integer cantidad, Integer cantidadMin) {
        this.id = id;
        this.almacen = almacen;
        this.producto = producto;
        this.cantidad = cantidad;
        this.cantidadMin = cantidadMin;
    }

    public AlmacenProductoId getId() {
        return id;
    }

    public void setId(AlmacenProductoId id) {
        this.id = id;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Product getProducto() {
        return producto;
    }

    public void setProducto(Product producto) {
        this.producto = producto;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlmacenProducto)) return false;
        AlmacenProducto that = (AlmacenProducto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
