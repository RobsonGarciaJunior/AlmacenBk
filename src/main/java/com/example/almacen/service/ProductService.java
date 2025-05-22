package com.example.almacen.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.almacen.model.persistence.Product;
import com.example.almacen.model.service.ProductDTO;
import com.example.almacen.repository.IProductRepository;
import com.example.almacen.security.repository.IUserRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	IProductRepository  productRepository;

	@Autowired
	IUserRepository userRepository;
	@Override
    public List<ProductDTO> findAll() {
        // Ignoramos userId porque no se usa en la consulta
        Iterable<Product> products = productRepository.findAllProducts();

        return toDTOList(products);
    }

    @Override
    public Boolean deleteProduct(Integer idProduct) {
        Product product = productRepository.findProductById(idProduct);

        if (product != null) {
            productRepository.deleteById(idProduct);
            return true;
        }
        return false;
    }

    private List<ProductDTO> toDTOList(Iterable<Product> products) {
        return StreamSupport.stream(products.spliterator(), false)
                .map(p -> new ProductDTO(p.getId(), p.getNombre(), p.getFoto(), p.getHabilitado()))
                .collect(Collectors.toList());
    }

}
