package com.inventario.inventariomicroservice.Service;

import com.inventario.inventariomicroservice.DTO.VentaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.List;

public interface VentaService {
    List<VentaDto> findAll();

    ResponseEntity<VentaDto> findById(@PathVariable Integer id);

    ResponseEntity<VentaDto> create(@PathVariable Integer medicamento, @RequestBody VentaDto ventaDto);

    List<VentaDto> findByFecha(@PathVariable Instant fechaInicial, @PathVariable Instant fechaFinal);
}
