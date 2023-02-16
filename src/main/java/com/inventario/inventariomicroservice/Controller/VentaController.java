package com.inventario.inventariomicroservice.Controller;

import com.inventario.inventariomicroservice.DTO.VentaDto;
import com.inventario.inventariomicroservice.Service.VentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping("/all")
    public List<VentaDto> findAll() {
        return ventaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDto> findById(@PathVariable Integer id) {
        return ventaService.findById(id);
    }

    @PostMapping("/save/{id}")
    public ResponseEntity<VentaDto> create(@PathVariable Integer id, @RequestBody VentaDto ventaDto) {
        return ventaService.create(id, ventaDto);
    }
}
