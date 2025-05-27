package com.example.almacen.service;

import java.util.List;

import com.example.almacen.model.service.ProductoStockDTO;

public interface IAlmacenService {

	List<ProductoStockDTO> getStockByAlmacen(Integer id, Integer cantidadMin);

	void updateStock(Integer id, Integer productoId, Integer cantidad);

}
