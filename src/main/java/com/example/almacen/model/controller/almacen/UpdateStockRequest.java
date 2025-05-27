package com.example.almacen.model.controller.almacen;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateStockRequest {
    @NotNull(message = "El ID de producto es obligatorio")
    private Integer productoId;
    
    @NotNull(message = "La cantidad es obligatoria")
    private Integer cantidad; // Puede ser positivo (añadir) o negativo (retirar)
    
    public UpdateStockRequest() {}

	public UpdateStockRequest(@NotNull(message = "El ID de producto es obligatorio") Integer productoId,
			@NotNull(message = "La cantidad es obligatoria") Integer cantidad) {
		super();
		this.productoId = productoId;
		this.cantidad = cantidad;
	}

	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
    
    
}