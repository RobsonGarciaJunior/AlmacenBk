package com.example.almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.almacen.model.persistence.AlmacenProducto;
import com.example.almacen.model.persistence.AlmacenProductoId;

public interface IAlmacenProductoRepository extends JpaRepository<AlmacenProducto, AlmacenProductoId> {

	 @Query(value = "SELECT * FROM AlmacenProducto WHERE ALMACEN_ID = :almacenId AND (:cantidadMin IS NULL OR CANTIDAD <= :cantidadMin)", nativeQuery = true)
	    List<AlmacenProducto> findStockByAlmacen(
	        @Param("almacenId") Integer almacenId,
	        @Param("cantidadMin") Integer cantidadMin
	    );
}
