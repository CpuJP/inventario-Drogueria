package com.inventario.inventariomicroservice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = Medicamento.ENTITY_NAME)
@Table(name = Medicamento.TABLE_NAME, schema = "drogueria")
public class Medicamento implements Serializable {
    public static final String ENTITY_NAME = "Medicamento";
    public static final String TABLE_NAME = "medicamentos";
    public static final String COLUMN_ID_NAME = "id";
    public static final String COLUMN_NOMBRE_NAME = "nombre";
    public static final String COLUMN_LABORATORIO_NAME = "laboratorio";
    public static final String COLUMN_FECHAFABRICACION_NAME = "fecha_fabricacion";
    public static final String COLUMN_FECHAVENCIMIENTO_NAME = "fecha_vencimiento";
    public static final String COLUMN_CANTIDADSTOCK_NAME = "cantidad_stock";
    public static final String COLUMN_VALORUNITARIO_NAME = "valor_unitario";

    private Integer id;

    private String nombre;

    private String laboratorio;

    private LocalDate fechaFabricacion;

    private LocalDate fechaVencimiento;

    private Integer cantidadStock;

    private BigDecimal valorUnitario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    @Size(max = 255)
    @NotNull
    @Column(name = COLUMN_NOMBRE_NAME, nullable = false)
    public String getNombre() {
        return nombre;
    }

    @Size(max = 255)
    @NotNull
    @Column(name = COLUMN_LABORATORIO_NAME, nullable = false)
    public String getLaboratorio() {
        return laboratorio;
    }

    @NotNull
    @Column(name = COLUMN_FECHAFABRICACION_NAME, nullable = false)
    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    @NotNull
    @Column(name = COLUMN_FECHAVENCIMIENTO_NAME, nullable = false)
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    @NotNull
    @Column(name = COLUMN_CANTIDADSTOCK_NAME, nullable = false)
    public Integer getCantidadStock() {
        return cantidadStock;
    }

    @NotNull
    @Column(name = COLUMN_VALORUNITARIO_NAME, nullable = false, precision = 10, scale = 2)
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

}