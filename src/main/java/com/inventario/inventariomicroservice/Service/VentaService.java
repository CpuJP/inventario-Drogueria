package com.inventario.inventariomicroservice.Service;

import com.inventario.inventariomicroservice.DTO.VentaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VentaService {
    List<VentaDto> findAll();

    ResponseEntity<VentaDto> findById(@PathVariable Integer id);

    ResponseEntity<VentaDto> create(@PathVariable Integer medicamento, @RequestBody VentaDto ventaDto);
}
