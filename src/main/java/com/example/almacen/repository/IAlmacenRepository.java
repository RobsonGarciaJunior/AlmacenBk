package com.example.almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.almacen.model.persistence.Almacen;

public interface IAlmacenRepository extends JpaRepository<Almacen, Integer> {
    // Consultas básicas automáticas
    List<Almacen> findByNombreContainingIgnoreCase(String nombre);
    
    // Query nativa para JOINs complejos (ej: con AlmacenProducto)
    @Query(value = """
        SELECT a.nombre, COUNT(ap.producto_id) as total_productos 
        FROM Almacen a
        LEFT JOIN AlmacenProducto ap ON a.id = ap.almacen_id
        GROUP BY a.id
        """, nativeQuery = true)
    List<Object[]> contarProductosPorAlmacen();
}
