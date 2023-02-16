package com.inventario.inventariomicroservice.Repository;

import com.inventario.inventariomicroservice.Entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>, JpaSpecificationExecutor<Medicamento> {
}