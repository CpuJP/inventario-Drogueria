package com.inventario.inventariomicroservice.Service;

import com.inventario.inventariomicroservice.DTO.VentaDto;
import com.inventario.inventariomicroservice.Entity.Medicamento;
import com.inventario.inventariomicroservice.Entity.Venta;
import com.inventario.inventariomicroservice.Exception.MessageBadRequestException;
import com.inventario.inventariomicroservice.Exception.MessageConflictException;
import com.inventario.inventariomicroservice.Exception.MessageNotFoundException;
import com.inventario.inventariomicroservice.Repository.MedicamentoRepository;
import com.inventario.inventariomicroservice.Repository.VentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "productService")
public class VentaServiceimpl implements VentaService {

    private final VentaRepository ventaRepository;
    private final MedicamentoRepository medicamentoRepository;
    private final MedicamentoService medicamentoService;
    private final ModelMapper modelMapper;

    public VentaServiceimpl(VentaRepository ventaRepository, ModelMapper modelMapper, MedicamentoRepository medicamentoRepository, MedicamentoService medicamentoService) {
        this.ventaRepository = ventaRepository;
        this.modelMapper = modelMapper;
        this.medicamentoRepository = medicamentoRepository;
        this.medicamentoService = medicamentoService;
    }

    @Override
    public List<VentaDto> findAll() {
        List<Venta> ventas = ventaRepository.findAll();
        return ventas.stream()
                .map(venta -> modelMapper.map(venta, VentaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<VentaDto> findById(Integer id) {
        Optional<Venta> venta = Optional.ofNullable(ventaRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException("La venta con id: " + id + " no existe")));
        if (venta.isPresent()) {
            return ResponseEntity.ok(modelMapper.map(venta.get(), VentaDto.class));
        } else {
            throw new MessageNotFoundException("La venta con id: " + id + " no existe");
        }
    }

    @Override
    public ResponseEntity<VentaDto> create(Integer medicamento, VentaDto ventaDto) {
        if(ventaDto.getCantidad() == null ||ventaDto.getFechaHora() == null || ventaDto.getMedicamento() == null) {
            throw new MessageBadRequestException("Los campos cantidad, fecha y Hora, medicamento no pueden ser nulos");
        }
        Medicamento medicamentoLoad = medicamentoRepository.findById(medicamento)
                .orElseThrow(() -> new MessageNotFoundException("La medicamento con id: " + medicamento + " no existe"));
        Integer valdiarExistencia = medicamentoLoad.getCantidadStock();
        if (ventaDto.getCantidad() > valdiarExistencia) {
            throw new MessageConflictException("El medicamento no cuenta con stock suficiente, sólo cuenta con: " + valdiarExistencia);
        } else if (ventaDto.getCantidad() <= 0) {
            throw new MessageConflictException("Ingrese una cantidad válida, mínimo 1 y máximo: " + valdiarExistencia);
        } else {
            Integer restarStock = valdiarExistencia - ventaDto.getCantidad();
            medicamentoLoad.setCantidadStock(restarStock);
            medicamentoRepository.save(medicamentoLoad);
            Venta venta = modelMapper.map(ventaDto, Venta.class);
            venta.setValorUnitario(medicamentoLoad.getValorUnitario());
            venta.setValorTotal(venta.getValorUnitario().multiply(BigDecimal.valueOf(venta.getCantidad())));
            Venta savedVenta = ventaRepository.save(venta);
            return ResponseEntity.ok(modelMapper.map(savedVenta, VentaDto.class));
        }
    }
}
