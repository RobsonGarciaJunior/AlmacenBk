package com.example.almacen.service;

import java.util.List;

import model.service.ProductDTO;

public interface IProductService {

	List<ProductDTO> findAll(Integer userId);
	
}
