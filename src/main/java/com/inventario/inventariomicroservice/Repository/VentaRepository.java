package com.inventario.inventariomicroservice.Repository;

import com.inventario.inventariomicroservice.Entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VentaRepository extends JpaRepository<Venta, Integer>, JpaSpecificationExecutor<Venta> {
}