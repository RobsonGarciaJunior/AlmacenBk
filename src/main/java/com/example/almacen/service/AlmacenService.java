package com.example.almacen.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.almacen.model.controller.almacen.ProductoStockGetResponse;
import com.example.almacen.model.persistence.AlmacenProducto;
import com.example.almacen.model.persistence.AlmacenProductoId;
import com.example.almacen.model.service.ProductoStockDTO;
import com.example.almacen.repository.IAlmacenProductoRepository;

@Service
public class AlmacenService implements IAlmacenService{

    @Autowired
    private IAlmacenProductoRepository almacenProductoRepository;
	
    @Override
    public List<ProductoStockDTO> getStockByAlmacen(Integer almacenId, Integer cantidadMin) {
        List<AlmacenProducto> productos = almacenProductoRepository.findStockByAlmacen(almacenId, cantidadMin);

        return productos.stream().map(ap -> {
            ProductoStockDTO dto = new ProductoStockDTO();
            dto.setProductoId(ap.getProducto().getId());
            dto.setNombreProducto(ap.getProducto().getNombre());
            dto.setFotoProducto(ap.getProducto().getFoto());
            dto.setAlmacenId(ap.getAlmacen().getId());
            dto.setNombreAlmacen(ap.getAlmacen().getNombre());
            dto.setCantidad(ap.getCantidad());
            dto.setCantidadMin(ap.getCantidadMin());
            dto.setHabilitado(ap.getProducto().getHabilitado());
            return dto;
        }).collect(Collectors.toList());
    }

    private ProductoStockGetResponse convertToResponse(ProductoStockDTO dto) {
        ProductoStockGetResponse response = new ProductoStockGetResponse();
        response.setProductoId(dto.getProductoId());
        response.setNombreProducto(dto.getNombreProducto());
        response.setFotoProducto(dto.getFotoProducto());
        response.setAlmacenId(dto.getAlmacenId());
        response.setNombreAlmacen(dto.getNombreAlmacen());
        response.setCantidad(dto.getCantidad());
        response.setCantidadMinima(dto.getCantidadMin());
        response.setHabilitado(dto.getHabilitado());
        response.setNecesitaReposicion(dto.getCantidad() <= dto.getCantidadMin());
        return response;
    }

    @Override
    public void updateStock(Integer almacenId, Integer productoId, Integer cantidad) {
        AlmacenProductoId id = new AlmacenProductoId(almacenId, productoId);
        
        AlmacenProducto almacenProducto = almacenProductoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado en el almacén"));
        
        almacenProducto.setCantidad(cantidad);
        
        almacenProductoRepository.save(almacenProducto);
    }
}
