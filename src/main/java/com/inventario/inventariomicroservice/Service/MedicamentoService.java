package com.inventario.inventariomicroservice.Service;

import com.inventario.inventariomicroservice.DTO.MedicamentoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MedicamentoService {
    List<MedicamentoDto> findAll();
    ResponseEntity<MedicamentoDto> findById(@PathVariable Integer id);
    ResponseEntity<MedicamentoDto> create(@RequestBody MedicamentoDto medicamentoDto);
    ResponseEntity<MedicamentoDto> update(@PathVariable Integer id, @RequestBody MedicamentoDto medicamentoDto);
    ResponseEntity<MedicamentoDto> delete(@PathVariable Integer id);

}
