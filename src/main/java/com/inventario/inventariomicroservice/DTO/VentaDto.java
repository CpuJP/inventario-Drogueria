package com.inventario.inventariomicroservice.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link com.inventario.inventariomicroservice.Entity.Venta} entity
 */
@Data
public class VentaDto implements Serializable {
    private  Integer id;
    @NotNull
    private  Instant fechaHora;
    @NotNull
    private  MedicamentoDto medicamento;
    @NotNull
    private  Integer cantidad;
    @NotNull
    private  BigDecimal valorUnitario;
    @NotNull
    private  BigDecimal valorTotal;
}