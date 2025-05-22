package com.example.almacen.service;

import java.util.List;

import com.example.almacen.model.service.ProductDTO;

public interface IProductService {

	List<ProductDTO> findAll();

	Boolean deleteProduct(Integer idProduct);
	
}
