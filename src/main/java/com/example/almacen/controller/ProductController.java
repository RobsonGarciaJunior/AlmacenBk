package com.example.almacen.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.almacen.model.controller.product.ProductGetResponse;
import com.example.almacen.model.service.ProductDTO;
import com.example.almacen.security.model.User;
import com.example.almacen.service.IProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	@GetMapping("findAll")
	public ResponseEntity<List<ProductGetResponse>> getProducts(Authentication authentication) throws IOException{

		User user = (User) authentication.getPrincipal();

		List <ProductDTO> listProductDTO = productService.findAll();
		List<ProductGetResponse> response = new ArrayList<ProductGetResponse>(); 

		//Transform every DTO from the list to GetResponse
		for(ProductDTO productDTO: listProductDTO) {
			response.add(convertFromProductDTOToGetResponse(productDTO));
		}
		return new ResponseEntity<List<ProductGetResponse>>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteChatById(@PathVariable("id") Integer idProduct, Authentication authentication){
		User user = (User) authentication.getPrincipal();
//		ChatGetResponse response = new ChatGetResponse();
		Boolean isDeleted = productService.deleteProduct(idProduct);
//		response = convertFromChatDTOToGetResponse(chatDTO);
		return new ResponseEntity<>(isDeleted, HttpStatus.OK);
	}

	private ProductGetResponse convertFromProductDTOToGetResponse(ProductDTO productDTO) {
		ProductGetResponse response = new ProductGetResponse(
				productDTO.getId(), 
				productDTO.getNombre(),	
				productDTO.getFoto(),
				productDTO.getHabilitado()
				);
		return response;
	}
}
