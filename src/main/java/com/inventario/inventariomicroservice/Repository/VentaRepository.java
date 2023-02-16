package com.inventario.inventariomicroservice.Repository;

import com.inventario.inventariomicroservice.Entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Integer>, JpaSpecificationExecutor<Venta> {
    @Transactional(readOnly = true)
    List<Venta> findVentasByFechaHoraBetween(Instant fechaInicial, Instant fechaFinal);
}