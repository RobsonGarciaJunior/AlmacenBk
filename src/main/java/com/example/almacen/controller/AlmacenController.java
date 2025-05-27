package com.example.almacen.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.almacen.model.controller.almacen.ProductoStockGetResponse;
import com.example.almacen.model.controller.almacen.UpdateStockRequest;
import com.example.almacen.model.service.ProductoStockDTO;
import com.example.almacen.service.IAlmacenService;

@RestController
@RequestMapping("api/almacenes")
public class AlmacenController {
    
    @Autowired
    private IAlmacenService almacenService;

    @GetMapping("/{id}/stock")
    public ResponseEntity<List<ProductoStockGetResponse>> getStockByAlmacen(
            @PathVariable Integer id,
            @RequestParam(required = false) Integer cantidadMin) {
        
        List<ProductoStockDTO> stock = almacenService.getStockByAlmacen(id, cantidadMin);
        List<ProductoStockGetResponse> response = stock.stream()
            .map(this::toProductoStockResponse)
            .collect(Collectors.toList());
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/stock")
    public ResponseEntity<Void> updateStock(
            @PathVariable Integer id,
            @RequestBody UpdateStockRequest request) {
        
        almacenService.updateStock(id, request.getProductoId(), request.getCantidad());
        return ResponseEntity.ok().build();
    }
    
    private ProductoStockGetResponse toProductoStockResponse(ProductoStockDTO dto) {
        return new ProductoStockGetResponse(
            dto.getProductoId(),
            dto.getNombreProducto(),
            dto.getFotoProducto(),
            dto.getAlmacenId(),
            dto.getNombreAlmacen(),
            dto.getCantidad(),
            dto.getCantidadMin(),
            dto.getHabilitado(),
            dto.getCantidad() <= dto.getCantidadMin()
        );
    }
}