package com.inventario.inventariomicroservice.Service;

import com.inventario.inventariomicroservice.DTO.MedicamentoDto;
import com.inventario.inventariomicroservice.Entity.Medicamento;
import com.inventario.inventariomicroservice.Exception.MessageBadRequestException;
import com.inventario.inventariomicroservice.Exception.MessageNotFoundException;
import com.inventario.inventariomicroservice.Repository.MedicamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "medicamentoService")
public class MedicamentoServiceimpl implements MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final ModelMapper modelMapper;

    public MedicamentoServiceimpl(MedicamentoRepository medicamentoRepository, ModelMapper modelMapper) {
        this.medicamentoRepository = medicamentoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MedicamentoDto> findAll() {
        List<Medicamento> medicamentos = medicamentoRepository.findAll();
        return medicamentos.stream()
                .map(medicamento -> modelMapper.map(medicamento, MedicamentoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<MedicamentoDto> findById(Integer id) {
        Optional<Medicamento> medicamento = Optional.ofNullable(medicamentoRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException("El medicamento con id: " + id + " no existe")));
        if(medicamento.isPresent()) {
            return ResponseEntity.ok(modelMapper.map(medicamento.get(), MedicamentoDto.class));
        } else {
            throw new MessageNotFoundException("El medicamento con id: " + id + " no existe");
        }
    }

    @Override
    public ResponseEntity<MedicamentoDto> create(MedicamentoDto medicamentoDto) {
        if(medicamentoDto.getNombre() == null || medicamentoDto.getFechaFabricacion() == null || medicamentoDto.getFechaVencimiento() == null || medicamentoDto.getCantidadStock() == null || medicamentoDto.getValorUnitario() == null) {
            throw new MessageBadRequestException("Todos los campos son obligatorios");
        }
        Medicamento medicamento = modelMapper.map(medicamentoDto, Medicamento.class);
        Medicamento savedMedicamento = medicamentoRepository.save(medicamento);
        return ResponseEntity.ok(modelMapper.map(savedMedicamento, MedicamentoDto.class));
    }

    @Override
    public ResponseEntity<MedicamentoDto> update(Integer id, MedicamentoDto medicamentoDto) {
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException("El medicamento con id: " + id + " no existe"));
        medicamento.setNombre(medicamentoDto.getNombre());
        medicamento.setLaboratorio(medicamentoDto.getLaboratorio());
        medicamento.setFechaFabricacion(medicamentoDto.getFechaFabricacion());
        medicamento.setFechaVencimiento(medicamentoDto.getFechaVencimiento());
        medicamento.setCantidadStock(medicamentoDto.getCantidadStock());
        medicamento.setValorUnitario(medicamentoDto.getValorUnitario());

        if(medicamento.getNombre() == null || medicamento.getFechaFabricacion() == null || medicamento.getFechaVencimiento() == null || medicamento.getCantidadStock() == null || medicamento.getValorUnitario() == null) {
            throw new MessageBadRequestException("Todos los campos son obligatorios");
        }

        Medicamento updatedMedicamento = medicamentoRepository.save(medicamento);
        return ResponseEntity.ok(modelMapper.map(updatedMedicamento, MedicamentoDto.class));
    }

    @Override
    public ResponseEntity<MedicamentoDto> delete(Integer id) {
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException("El medicamento con id: " + id + " no existe"));
        medicamentoRepository.delete(medicamento);
        return ResponseEntity.ok().build();
    }
}
