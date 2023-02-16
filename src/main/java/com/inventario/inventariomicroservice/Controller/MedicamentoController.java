package com.inventario.inventariomicroservice.Controller;

import com.inventario.inventariomicroservice.DTO.MedicamentoDto;
import com.inventario.inventariomicroservice.Service.MedicamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamento")
public class MedicamentoController {
    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping("/all")
    public List<MedicamentoDto> findAll() {
        return medicamentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDto> findById(@PathVariable Integer id) {
        return medicamentoService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<MedicamentoDto> create(@RequestBody MedicamentoDto medicamentoDto) {
        return medicamentoService.create(medicamentoDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MedicamentoDto> update(@PathVariable Integer id, @RequestBody MedicamentoDto medicamentoDto) {
        return medicamentoService.update(id, medicamentoDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MedicamentoDto> delete(@PathVariable Integer id) {
        return medicamentoService.delete(id);
    }
}
