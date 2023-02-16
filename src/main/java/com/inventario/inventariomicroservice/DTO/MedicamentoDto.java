package com.inventario.inventariomicroservice.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.inventario.inventariomicroservice.Entity.Medicamento} entity
 */
@Data
public class MedicamentoDto implements Serializable {
    private Integer id;
    @Size(max = 255)
    @NotNull
    private String nombre;
    @Size(max = 255)
    @NotNull
    private String laboratorio;
    @NotNull
    private LocalDate fechaFabricacion;
    @NotNull
    private LocalDate fechaVencimiento;
    @NotNull
    private Integer cantidadStock;
    @NotNull
    private BigDecimal valorUnitario;
}