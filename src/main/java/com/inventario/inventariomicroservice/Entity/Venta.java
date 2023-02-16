package com.inventario.inventariomicroservice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = Venta.ENTITY_NAME)
@Table(name = Venta.TABLE_NAME, schema = "drogueria", indexes = {
        @Index(name = "medicamento_id", columnList = "medicamento_id")
})
public class Venta implements Serializable {
    public static final String ENTITY_NAME = "Venta";
    public static final String TABLE_NAME = "ventas";
    public static final String COLUMN_ID_NAME = "id";
    public static final String COLUMN_FECHAHORA_NAME = "fecha_hora";
    public static final String COLUMN_CANTIDAD_NAME = "cantidad";
    public static final String COLUMN_VALORUNITARIO_NAME = "valor_unitario";
    public static final String COLUMN_VALORTOTAL_NAME = "valor_total";

    private Integer id;

    private Instant fechaHora;

    private Medicamento medicamento;

    private Integer cantidad;

    private BigDecimal valorUnitario;

    private BigDecimal valorTotal;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    @NotNull
    @Column(name = COLUMN_FECHAHORA_NAME, nullable = false)
    public Instant getFechaHora() {
        return fechaHora;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medicamento_id", nullable = false)
    public Medicamento getMedicamento() {
        return medicamento;
    }

    @NotNull
    @Column(name = COLUMN_CANTIDAD_NAME, nullable = false)
    public Integer getCantidad() {
        return cantidad;
    }

    @NotNull
    @Column(name = COLUMN_VALORUNITARIO_NAME, nullable = false, precision = 10, scale = 2)
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    @NotNull
    @Column(name = COLUMN_VALORTOTAL_NAME, nullable = false, precision = 10, scale = 2)
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

}